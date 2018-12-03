#!/bin/python

import sdr
import pprint
import sys
import time
import requests
import json
from requests.auth import HTTPBasicAuth
from colors import red, green

RED   = "\033[1;31m"
BLUE  = "\033[1;34m"
CYAN  = "\033[1;36m"
GREEN = "\033[0;32m"
RESET = "\033[0;0m"
FAIL = '\x1b[31m'
ENDC = "\033[0m"


baseURL = "http://localhost:8080/rest/api"
jsonwsURL = "http://150.183.117.133:8080/api/jsonws"

user = {}
user['admin'] = "sunilahn@gmail.com"
user['guest'] = ""
user['member'] = "siahnM@daum.net"
user['user'] = "siahnU@daum.net"
user['group'] = "siahnA@daum.net"
user['owner'] = "siahnO@daum.net"

password = {}
password['admin'] = "cfdthfqj"
password['guest'] = ""
password['member'] = "cfdthfqj2"
password['user'] = "cfdthfqj2"
password['group'] = "cfdthfqj2"
password['owner'] = "cfdthfqj2"

_PRINT_DEBUG = False
_num_error = 0

# siahnA
AllowedUserId = 22548

# Materials
TargetGroupId = 20603

# TargetDataType
TargetDataType = 22718

def printStatusError(code) :
    sys.stdout.write(RED)
    print ("[FAIL] Status Code :" + code)
    sys.stdout.write(RESET)
    _num_error += 1

def printCheckError(msg) :
    sys.stdout.write(RED)
    print ("[FAIL] Check :" + msg)
    sys.stdout.write(RESET)
    _num_error += 1

def printCheckSuccess(msg) :
    if _PRINT_DEBUG :
        print ("[SUCCESS] Check :" + msg)

def printPermissionError(msg) :
    sys.stdout.write(RED)
    print ("[Failed] : PermissionError :" + str(msg))
    sys.stdout.write(RESET)

def printPermissionSuccess(msg) :
    if _PRINT_DEBUG :
        print ("[SUCCESS] " + str(msg))


def handleHTTP(data, tuser, protocol="GET", url=None) :
    if url is not None :
        accessURL = url
    else :
        accessURL = jsonwsURL + "/invoke"

    try:
        if protocol == "GET" :
            response = requests.get(accessURL, data=data, auth=HTTPBasicAuth(user[tuser], password[tuser]))
        else :
            response = requests.post(accessURL, data=data, auth=HTTPBasicAuth(user[tuser], password[tuser]))
        response.raise_for_status()
    except requests.exceptions.HTTPError as e:
        printStatusError(response.status_code)
        return None
    return response


def handleResponse(data, success) :
    if 'exception' in data :
        if data['exception'] != "com.liferay.portal.security.auth.PrincipalException" :
            printPermissionError(data['exception'])
            return
        if success :
            printPermissionError(data['exception'])
        else :
            printPermissionSuccess(data['exception'])
    else :
        if success :
            printPermissionSuccess(data) #printSuccess(data)
        else :
            printPermissionError(data) #printError(data)

def getCollectionList(tuser, success) :
    if _PRINT_DEBUG :
        print ("###Get Collection List for " + tuser)

    data = '''{
        "/SDR_base-portlet.collection/get-list" : { }
    }'''

    r = handleHTTP(data, tuser)
    if r is not None :
        tr = r.json()
        handleResponse(tr, success)
        if 'exception' not in tr :
            return len(tr)
        else :
            return -1
    return -1


def getCollection(tuser, col, success) :
    if _PRINT_DEBUG :
        print ("###Get Collection for " + tuser)
        print ("target Collection is " + str(col))

    data = '''{
        "/SDR_base-portlet.collection/get-collection" : { 
             "CollectionId" : %d
        }
    }''' % (col)

    r = handleHTTP(data, tuser)
    if r is not None :
        tr = r.json()
        handleResponse(tr, success)
        if 'exception' not in tr :
            return tr['collectionId']
        else :
            return -1
    return -1


def createCollection(tuser, success) :

    title = "Test Collection %f" % (time.time())

    if _PRINT_DEBUG :
        print ("###Creating Collection for " + tuser)
        print ("title : " + title)

    data = '''{
        "/SDR_base-portlet.collection/save" : {
            "collection" : {
                "title": "%s", 
                "groupId": %d
            }
        }
    }''' % (title, TargetGroupId)

    r = handleHTTP(data, tuser, "POST")
    if r is not None :
        tr = r.json()
        handleResponse(tr, success)
        if 'exception' not in tr :
            return tr['collectionId']
        else :
            return -1
    return -1



def updateCollection(tuser, col, success) :
    title = "Test Collection %f" % (time.time())
    if _PRINT_DEBUG :
        print ("###Update Collection for " + tuser)
        print ("Target " + str(col))
        print ("title : " + title)

    data = '''{
        "/SDR_base-portlet.collection/save" : {
            "collection" : {
                "collectionId" : %d,
                "title": "%s",
                "groupId": %d
            }
        }
    }''' % (col, title, TargetGroupId)

    r = handleHTTP(data, tuser, "POST")
    if r is not None :
        tr = r.json()
        handleResponse(tr, success)
        if 'exception' not in tr :
            return tr['collectionId']
        else :
            return -1
    return -1


def addUserToCollection(tuser, col, success) :
    if _PRINT_DEBUG :
        print ("###Add Allowed User to Collection for " + tuser)

    data = '''{
        "/SDR_base-portlet.collection_alloweduser/add-collection_-allowed-user" : {
            "collectionId" : %d,
            "userId": %d,
            "groupId": %d
        }
    }''' % (col, AllowedUserId, TargetGroupId)

    r = handleHTTP(data, tuser, "POST")
    if r is not None :
        tr = r.json()
        handleResponse(tr, success)
        if 'exception' not in tr :
            return tr['collectionId']
        else :
            return -1
    return -1

def setPerimssionforCollection(tuser, col, perm, success) :
    if _PRINT_DEBUG :
        print ("###set Permission for " + tuser)
        print ("Target " + str(col))

    data = '''{
        "/SDR_base-portlet.collection/set-permission" : {
            "collectionId" : %d,
            "accessPolicy": "%d",
            "groupId": %d
        }
    }''' % (col, perm, TargetGroupId)

    r = handleHTTP(data, tuser, "POST")
    if r is not None :
        tr = r.json()
        handleResponse(tr, success)
        if 'exception' not in tr :
            return tr['collectionId']
        else :
            return -1
    return -1

def deleteCollection(tuser, col, success) :
    title = "Test Collection %f" % (time.time())
    if _PRINT_DEBUG :
        print ("###Deleting Collection for " + tuser)
        print ("collection ID : " + str(col))

    data = '''{
        "/SDR_base-portlet.collection/delete" : {
            "collectionId" : %d,
            "groupId": %d
        }
    }''' % (col, TargetGroupId)

    r = handleHTTP(data, tuser, protocol="POST")
    if r is not None :
        tr = r.json()
        handleResponse(tr, success)
        if 'exception' not in tr :
            return tr['collectionId']
        else :
            return -1
    return -1


def updateCollectionforDataset(tuser, ds, col , success) :
    if _PRINT_DEBUG :
        print ("###Update Dataset for " + tuser)

    url = jsonwsURL + "/SDR_base-portlet.dataset/save"
    tmp_data = {'datasetId' : ds, 'collectionId' : col, 'groupId' : TargetGroupId}
    data = { 'vo' : json.dumps(tmp_data) }

    r = handleHTTP(data, tuser, protocol="POST", url=url)
    if r is not None :
        tr = r.json()
        handleResponse(tr, success)
        if 'exception' not in tr :
            return tr['datasetId']
        else :
            return -1
    return -1

def updateDataset(tuser, ds, success) :
    title = "Test Dataset %f" % (time.time())
    if _PRINT_DEBUG :
        print ("###Update Dataset for " + tuser)
        print ("title : " + title)

    url = jsonwsURL + "/SDR_base-portlet.dataset/save"
    tmp_data = {'datasetId' : ds, 'title' : title, 'groupId' : TargetGroupId }
    data = { 'vo' : json.dumps(tmp_data) }

    r = handleHTTP(data, tuser, protocol="POST", url=url)
    if r is not None :
        tr = r.json()
        handleResponse(tr, success)
        if 'exception' not in tr :
            return tr['datasetId']
        else :
            return -1
    return -1

def getDataset(tuser, ds, success) :
    if _PRINT_DEBUG :
        print ("###Get Dataset for " + tuser)
        print ("target dataset is " + str(ds))

    data = '''{
        "/SDR_base-portlet.dataset/get-dataset" : {
             "datasetId" : %d,
             "groupId" : %d
        }
    }''' % (ds, TargetGroupId)

    r = handleHTTP(data, tuser)
    if r is not None :
        tr = r.json()
        handleResponse(tr, success)
        if 'exception' not in tr :
            return tr['datasetId']
        else :
            return -1
    return -1


def createDataset(tuser, col, success) :
    title = "Test Dataset %f" % (time.time())
    if _PRINT_DEBUG :
        print ("###Create Dataset for " + tuser)
        print ("collection ID : " + str(col))
        print ("title : " + title)

    url = jsonwsURL + "/SDR_base-portlet.dataset/save"
    tmp_data = {'collectionId' : col, 'dataTypeId' :  TargetDataType, 'title' : title, 'groupId' : TargetGroupId }
    data = { 'vo' : json.dumps(tmp_data)  }

    r = handleHTTP(data, tuser, protocol="POST", url=url)
    if r is not None :
        tr = r.json()
        handleResponse(tr, success)
        if 'exception' not in tr :
            return tr['datasetId']
        else :
            return -1
    return -1

def deleteDataset(tuser, ds, success) :
    if _PRINT_DEBUG :
        print ("###Delete Dataset for " + tuser)
        print ("dataset ID : " + str(ds))

    data = '''{
        "/SDR_base-portlet.dataset/delete-dataset" : {
            "DatasetPK" : %d,
            "groupId" : %d
        }
    }''' % (ds, TargetGroupId)

    r = handleHTTP(data, tuser, protocol="POST")
    if r is not None :
        tr = r.json()
        handleResponse(tr, success)
        if 'exception' not in tr :
            return tr['datasetId']
        else :
            return -1
    return -1


def searchDataset(tuser, success) :
    if _PRINT_DEBUG :
        print ("###Search Dataset for " + tuser)

    data = '''{
        "/search" : {
            "DataType" : "bat_conv" 
        }
    }'''

    url = baseURL + "/search/DataType:actest/site/%d" % (TargetGroupId)
    #url = baseURL + "/site"

    r = requests.get(url, auth=HTTPBasicAuth(user[tuser], password[tuser]))

    if r is not None :
        tr = r.json()
        handleResponse(tr, success)
        if 'exception' not in tr :
            return len(tr)
        else :
            return -1
    return -1


def printSeperator() :
    if _PRINT_DEBUG :
        print ("")


def checkEqual(a, b):
    if a == b :
        printCheckSuccess("Check " + str(a) + " and " + str(b))
    else :
        printCheckError("Check " + str(a) + " and " + str(b))


def checkNotEqual(a, b):
    if a == b :
        printCheckError("Check " + str(a) + " and " + str(b))
    else:
        printCheckSuccess("Check " + str(a) + " and " + str(b))



SDR_PERM_GROUP_READ = 0x01
SDR_PERM_GROUP_CREATE = 0x02
SDR_PERM_GROUP_UPDATE = 0x04

SDR_PERM_COMMUNITY_READ = 0x10
SDR_PERM_COMMUNITY_CREATE = 0x20
SDR_PERM_COMMUNITY_UPDATE = 0x40

SDR_PERM_USER_READ = 0x100
SDR_PERM_USER_CREATE = 0x200
SDR_PERM_USER_UPDATE = 0x400

SDR_PERM_GUEST_READ = 0x1000

'''
SDR_ACTION_READ   = 1
SDR_ACTION_UPDATE = 2
SDR_ACTION_CREATE = 3
SDR_ACTION_DELETE = 4
SDR_ACTION_SEARCH = 5
SDR_ACTION_REQUEST = 6
SDR_ACTION_NONE = 7

SDR_ACTION_COLLECTION = 0
SDR_ACTION_COLLECTION_READ   = SDR_ACTION_COLLECTION + SDR_ACTION_READ
SDR_ACTION_COLLECTION_CREATE = SDR_ACTION_COLLECTION + SDR_ACTION_CREATE
SDR_ACTION_COLLECTION_UPDATE = SDR_ACTION_COLLECTION + SDR_ACTION_UPDATE
SDR_ACTION_COLLECTION_DELETE = SDR_ACTION_COLLECTION + SDR_ACTION_DELETE
SDR_ACTION_COLLECTION_SEARCH = SDR_ACTION_COLLECTION + SDR_ACTION_SEARCH

SDR_ACTION_DATASET = 0x10
SDR_ACTION_DATASET_READ      = SDR_ACTION_DATASET + SDR_ACTION_READ
SDR_ACTION_DATASET_CREATE    = SDR_ACTION_DATASET + SDR_ACTION_CREATE
SDR_ACTION_DATASET_UPDATE    = SDR_ACTION_DATASET + SDR_ACTION_UPDATE
SDR_ACTION_DATASET_DELETE    = SDR_ACTION_DATASET + SDR_ACTION_DELETE
SDR_ACTION_DATASET_SEARCH    = SDR_ACTION_DATASET + SDR_ACTION_SEARCH
'''


def getExpectedResultforCollection(action, tuser, perm) :
    if tuser == 'admin' :
        return True

    if tuser == 'owner' :
        return True

    if action == "C_D" :
        return False

    if action == "C_C" :
        if (tuser == 'member') or (tuser == 'group') :
            return True
        return False

    policy = 0;
    if tuser == 'group' :
        policy = SDR_PERM_GROUP_READ + SDR_PERM_USER_READ + SDR_PERM_GUEST_READ
    elif tuser == 'member':
        policy = SDR_PERM_COMMUNITY_READ + SDR_PERM_USER_READ + SDR_PERM_GUEST_READ
    elif tuser == 'user':
        policy = SDR_PERM_USER_READ + SDR_PERM_GUEST_READ
    else :
        policy = SDR_PERM_GUEST_READ

    if action == "C_U" :
        policy = policy << 2
    elif action == "D_C" :
        policy = policy << 1

    if (policy & perm) > 0  :
        return True
    else :
        return False


def getExpectedResultforDataset(action, tuser, perm) :
    if tuser == 'admin' :
        return True

    if (action == "D_D") or (action == "D_U" ) :
        return False

    if tuser == 'owner' :
        return True

    return getExpectedResultforCollection(action, tuser, perm)


def prepareTest(tuser, perm) :
    if _PRINT_DEBUG :
        print ("")
        print ("prepareTest========================================================")
    col = createCollection(tuser, True)
    setPerimssionforCollection(tuser, col, perm, True)
    addUserToCollection(tuser, col, True)
    ds = createDataset(tuser, col, True)
    return (col, ds)


def cleanTest(tuser, col, ds) :
    if _PRINT_DEBUG :
        print ("")
        print ("cleanTest========================================================")
    deleteDataset(tuser, ds, True)
    deleteCollection(tuser, col, True)


def doTest(tuser, col, ds, perm) :
    if _PRINT_DEBUG :
        print ("")
        print ("doTest========================================================")
        print ("(collection : " + str(col) + ") (dataset : " + str(ds) + ") (user : " + tuser + ") (perm : " + str(perm) + ")")

    # create collection test
    col2 = createCollection(tuser, getExpectedResultforCollection('C_C', tuser, perm))

    # read collection test
    getCollection(tuser, col, getExpectedResultforCollection('C_R', tuser, perm))

    # update collection test
    updateCollection(tuser, col, getExpectedResultforCollection('C_U', tuser, perm))

    # create dataset test
    ds2 = createDataset(tuser, col, getExpectedResultforDataset('D_C', tuser, perm))

    # read dataset test
    getDataset(tuser,ds,getExpectedResultforDataset('D_R', tuser, perm))

    # update dataset test
    updateDataset(tuser,ds,getExpectedResultforDataset('D_U', tuser, perm))

    # delete dataset test
    if (tuser == 'admin') :
        deleteDataset(tuser,ds2,getExpectedResultforDataset('D_D', tuser, perm))
    else :
        deleteDataset(tuser,ds, getExpectedResultforDataset('D_D', tuser, perm))
        if ds2 > 0 :
            deleteDataset('admin', ds2, True)

    # delete collection test
    if (tuser == 'admin') or (tuser == 'owner') :
        deleteCollection(tuser, col2, getExpectedResultforCollection('C_D', tuser, perm))
    else :
        deleteCollection(tuser, col, getExpectedResultforCollection('C_D', tuser, perm))
        if col2 > 0 :
            deleteCollection('admin', col2, True)



SDR_PERM_GROUP_READ = 0x01
SDR_PERM_GROUP_CREATE = 0x02
SDR_PERM_GROUP_UPDATE = 0x04

SDR_PERM_COMMUNITY_READ = 0x10
SDR_PERM_COMMUNITY_CREATE = 0x20
SDR_PERM_COMMUNITY_UPDATE = 0x40

SDR_PERM_USER_READ = 0x100
SDR_PERM_USER_CREATE = 0x200
SDR_PERM_USER_UPDATE = 0x400

SDR_PERM_GUEST_READ = 0x1000


def basic_CRUD_Test() :
    target_perms = [0x1, 0x03, 0x7, 0x17, 0x37, 0x77, 0x177, 0x377, 0x777, 0x1777 ]
    #testers = ['guest','user','member','group','owner','admin' ]
    testers = ['user','member','group','owner','admin']

    for tp in target_perms :
        for tester in testers :
            col, ds = prepareTest('owner', tp)
            try :
                doTest(tester, col, ds, tp)
            except Exception as e:
                print ( str(e) )
            if col > 0 :
                cleanTest('admin', col, ds)


def basic_search_Test() :
    initial_num = searchDataset('admin', True)

    mycol = [0,0,0,0,0]
    myds  = [0,0,0,0,0]
    mycol[0], myds[0] = prepareTest('owner', 0x0)
    mycol[1], myds[1] = prepareTest('owner', 0x1)
    mycol[2], myds[2] = prepareTest('owner', 0x11)
    mycol[3], myds[3] = prepareTest('owner', 0x111)
    mycol[4], myds[4] = prepareTest('owner', 0x1111)

    try :
        if _PRINT_DEBUG :
            print ("")
            sys.stdout.write(GREEN)
            print ("doTest========================================================")
            sys.stdout.write(RESET)

        my_num = searchDataset('admin', True)
        checkEqual(initial_num + 5, my_num)

        my_num = searchDataset('owner', True)
        checkEqual(initial_num + 5, my_num)

        my_num = searchDataset('group', True)
        checkEqual(initial_num + 3, my_num)

        my_num = searchDataset('member', True)
        checkEqual(initial_num + 3, my_num)

        my_num = searchDataset('user', True)
        checkEqual(initial_num + 2, my_num)

        #my_num = searchDataset('guest', True)
        #checkEqual(initial_num + 1, my_num)

    except Exception as e:
        print ( str(e) )


    cleanTest('admin', mycol[0], myds[0])
    cleanTest('admin', mycol[1], myds[1])
    cleanTest('admin', mycol[2], myds[2])
    cleanTest('admin', mycol[3], myds[3])
    cleanTest('admin', mycol[4], myds[4])

def bulk_search_Test(num) :
    mycol = []
    myds  = []

    for i in range(0, num):
        tcol, tds = prepareTest('owner', 0x111)
        if tcol > 0 :
            mycol.append(tcol)
            myds.append(tds)

    try :
        if _PRINT_DEBUG :
            print ("")
            sys.stdout.write(GREEN)
            print ("doTest========================================================")
            sys.stdout.write(RESET)

        startT = time.clock()
        my_num = searchDataset('user', True)
        print ("Target Collections : " + str(num))
        print ("Items found : " + str(my_num))
        print ("Time taken : " + str(time.clock() - startT) )

        #my_num = searchDataset('guest', True)
        #checkEqual(initial_num + 1, my_num)

    except Exception as e:
        print ( str(e) )

    for i in range(0, num):
        cleanTest('admin', mycol[i], myds[i])


# test the screen shows RED Failure with the below command
# deleteCollection('guest', 21106, True)


#basic_CRUD_Test()

#basic_search_Test()

bulk_search_Test(1000)

print ("Total Errors : " + str(_num_error))