<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet" %>
<%@ page import="com.liferay.portal.kernel.util.WebKeys" %>
<%@ page import="com.liferay.portal.util.PortalUtil" %>
<%@ page import="javax.portlet.PortletSession" %>
<%@ page contentType="text/html" pageEncoding="UTF-8" %>

<style>
body { margin: 0; background-color: #f9f9f9; }
#central { width: 980px; margin: 25px auto 0 auto; }
#sidebar { position: fixed; top: 20px; }
#sidebar h1  { margin: 0 0 15px 0; font-size: 32px; font-weight: 100; color: #30ae7f; }
#sidebar h2 { margin: 0 0 5px 5px; font-size: 16px; font-weight: 200; }
#sidebar ul { margin: 0; padding: 0 0 0 10px; }
#sidebar ul li { margin-bottom: 5px; list-style: none; }
#sidebar ul li a { font-size: 12px; text-decoration: none; color: #666; transition: 0.5s; }
#sidebar ul li a:hover { color: #ca3246; }
#content { width: 715px; margin-left: 420px; }
#content ul { margin: 0 0 20px 0; padding: 0; }
li.blockList { border: 1px solid #d1d1d1; list-style: none; background-color: #fff; }
li.blockList h4 { margin: 0 ; padding: 10px 20px; border-bottom: 1px solid #d1d1d1; font-size: 24px; font-weight: 100; color: #45517d; }
li.blockList pre { margin: 0; padding: 20px; border-radius:4px; font-size: 11px; line-height:18px; font-weight: bold; color: #5e5e5e; }
li.blockList .block { margin: 0; padding: 0 20px; font-size: 12px; color: #666; }
li.blockList dl { margin: 0; padding: 10px 20px 20px 20px; font-size: 12px; line-height:18px; color: #333; }
li.blockList dl dt { font-size: 13px; font-weight: bold; }
li.blockList dl dd { margin-left: 15px; }
</style>

<div id="central">



        <div id="sidebar">
            <h1>SDR API</h1>
            <h2>Examples</h2>
            <ul>
                <li><a href="#site()">/rest/api/site</a></li>
                <li><a href="#siteCount()">/rest/api/site/count</a></li>
                <li><a href="#siteSize()">/rest/api/site/start/{start}/end/{end}</a></li>
                <li><a href="#site(long)">/rest/api/site/{groupId}/collection</a></li>
                <li><a href="#siteCount(long)">/rest/api/site/{groupId}/collection/count</a></li>
                <li><a href="#siteSize(long)">/rest/api/site/{groupId}/collection/start/{start}/end/{end}</a></li>
                <li><a href="#collection()">/rest/api/collection</a></li>
                <li><a href="#collectionCount()">/rest/api/collection/count</a></li>
                <li><a href="#collectionSize()">/rest/api/collection/start/{start}/end/{end}</a></li>
                <li><a href="#collection(long)">/rest/api/collection/{collectionId}</a></li>
                <li><a href="#collectionDataset(long)">/rest/api/collection/{collectionId}/dataset</a></li>
                <li><a href="#collectionDatasetPro(long)">/rest/api/collection/{collectionId}/dataset{?property}</a></li>
                <li><a href="#collectionDatasetSize(long)">/rest/api/collection/{collectionId}/dataset/start/{start}/end/{end}</a></li>
                <li><a href="#collectionDatasetSizePro(long)">/rest/api/collection/{collectionId}/dataset/start/{start}/end/{end}{?property}</a></li>
                <li><a href="#collectionDatasetCount(long)">/rest/api/collection/{collectionId}/dataset/count</a></li>
                <li><a href="#datatype()">/rest/api/datatype</a></li>
                <li><a href="#datatypeCount()">/rest/api/datatype/count</a></li>
                <li><a href="#datatypeSize()">/rest/api/datatype/start/{start}/end/{end}</a></li>
                <li><a href="#dataType(long)">/rest/api/datatype/{dataTypeId}</a></li>
                <li><a href="#dataset(long)">/rest/api/dataset/{datasetId}</a></li>
                <li><a href="#datasetPro(long)">/rest/api/dataset/{datasetId}{?property}</a></li>
                <li><a href="#datasetFile(long)">/rest/api/dataset/{datasetId}/file</a></li>
                <li><a href="#datasetFilePro(long)">/rest/api/dataset/{datasetId}/file{?property}</a></li>
                <li><a href="#datasetFileSize(long)">/rest/api/dataset/{datasetId}/file/start/{start}/end/{end}</a></li>
                <li><a href="#datasetFileSizePro(long)">/rest/api/dataset/{datasetId}/file/start/{start}/end/{end}{?property}</a></li>
                <li><a href="#datasetFileCount(long)">/rest/api/dataset/{datasetId}/file/count</a></li>
                <li><a href="#search" class="gray">/rest/api/search/{condition}</a></li>
                <li><a href="#searchCount" class="gray">/rest/api/search/{condition}/count</a></li>
                <li><a href="#searchSize" class="gray">/rest/api/search/{condition}/start/{start}/end/{end}</a></li>
                <li><a href="#searchDataType" class="gray">/rest/api/search/{condition}/datatype/{datatype}</a></li>
                <%--<li><a href="#searchDataTypeSize" class="gray">/rest/api/search/{condition}/datatype/{datatype}/start/{start}/end/{end}</a></li>--%>
                <li><a href="#datasetFile_down">/rest/api/file/dataset/{datasetId}</a></li>
                <li><a href="#datasetFilePath_down">/rest/api/file/dataset/{datasetId}/path/{FileName}</a></li>
            </ul>
        </div>




        <div id="content">
            <a name="site()">
                <!--   -->
            </a>
            
            
            
            
            <ul class="blockList">
                <li class="blockList">
                    <h4>/rest/api/site</h4>
                    <pre>@RequestMapping(value="/api/site",
                method=GET)
@ResponseStatus(value=OK)
@ResponseBody
public&nbsp;java.util.List&lt;java.util.Map&gt;&nbsp;site()
                                   throws com.liferay.portal.kernel.exception.SystemException</pre>
                    <div class="block">모든 사이트의 목록을 리스트</div>
                    <dl><dt><span class="strong">Returns:</span></dt>
                        <dd>List<map></map></dd>
                        <dt><span class="strong">Throws:</span></dt>
                        <dd><code>com.liferay.portal.kernel.exception.SystemException</code></dd>
                    </dl>
                </li>
            </ul>

            <a name="siteCount()">
                <!--   -->
            </a>
            <ul class="blockList">
                <li class="blockList">
                    <h4>/rest/api/site/count</h4>
                    <pre>@RequestMapping(value="/api/site/count",
                method=GET)
@ResponseStatus(value=OK)
@ResponseBody
public&nbsp;int&nbsp;site()
            throws com.liferay.portal.kernel.exception.SystemException</pre>
                    <div class="block">모든 사이트의 목록을 리스트 개수</div>
                    <dl><dt><span class="strong">Returns:</span></dt>
                        <dd>Integer<map></map></dd>
                        <dt><span class="strong">Throws:</span></dt>
                        <dd><code>com.liferay.portal.kernel.exception.SystemException</code></dd>
                    </dl>
                </li>
            </ul>
            <a name="siteSize()">
                <!--   -->
            </a>
            <ul class="blockList">
                <li class="blockList">
                    <h4>/api/site/start/{start}/end/{end}</h4>
                    <pre>@RequestMapping(value="/api/site/start/{start}/end/{end}",
                method=GET)
@ResponseStatus(value=OK)
@ResponseBody
public&nbsp;java.util.List&lt;java.util.Map&gt;&nbsp;siteSize(@PathVariable(value="start") int start,
                                                @PathVariable(value="end")   int end)
                                   throws com.liferay.portal.kernel.exception.SystemException</pre>
                    <div class="block">모든 사이트의 목록을 처음과 끝부분 지정한 리스트</div>
                    <dl><dt><span class="strong">Parameters:</span></dt><dd><code>start</code> - </dd><dd><code>end</code> -
                        <dt><span class="strong">Returns:</span></dt>
                        <dd>List<map></map></dd>
                        <dt><span class="strong">Throws:</span></dt>
                        <dd><code>com.liferay.portal.kernel.exception.SystemException</code></dd>
                    </dl>
                </li>
            </ul>
            
            
            
            
            <a name="site(long)">
                <!--   -->
            </a>
            <ul class="blockList">
                <li class="blockList">
                    <h4>/rest/api/site/{groupId}/collection</h4>
                    <pre>@RequestMapping(value="/api/site/{groupId}/collection",
                method=GET)
@ResponseStatus(value=OK)
@ResponseBody
public&nbsp;java.util.List&lt;java.util.Map&gt;&nbsp;site(@PathVariable(value="groupId")
                                                                            long&nbsp;groupId)
                                   throws com.liferay.portal.kernel.exception.SystemException,
                                          com.liferay.portal.kernel.exception.PortalException</pre>
                    <div class="block">{groupId}의 모든 컬렉션을 리스트</div>
                    <dl><dt><span class="strong">Returns:</span></dt>
                        <dd>List<map></map></dd>
                        <dt><span class="strong">Throws:</span></dt>
                        <dd><code>com.liferay.portal.kernel.exception.SystemException</code></dd>
                        <dd><code>com.liferay.portal.kernel.exception.PortalException</code></dd>
                    </dl>
                </li>
            </ul>
            <a name="siteCount(long)">
                <!--   -->
            </a>
            <ul class="blockList">
                <li class="blockList">
                    <h4>/rest/api/site/{groupId}/collection/count</h4>
                    <pre>@RequestMapping(value="/api/site/{groupId}/collection/count",
                method=GET)
@ResponseStatus(value=OK)
@ResponseBody
public&nbsp;int&nbsp;site(@PathVariable(value="groupId")&nbsp;long&nbsp;groupId)
                                   throws com.liferay.portal.kernel.exception.SystemException,
                                          com.liferay.portal.kernel.exception.PortalException</pre>
                    <div class="block">{groupId}의 모든 컬렉션을 리스트의 개수</div>
                    <dl><dt><span class="strong">Returns:</span></dt>
                        <dd>Integer<map></map></dd>
                        <dt><span class="strong">Throws:</span></dt>
                        <dd><code>com.liferay.portal.kernel.exception.SystemException</code></dd>
                        <dd><code>com.liferay.portal.kernel.exception.PortalException</code></dd>
                    </dl>
                </li>
            </ul>
            <a name="siteSize(long)">
                <!--   -->
            </a>
            <ul class="blockList">
                <li class="blockList">
                    <h4>/rest/api/site/{groupId}/collection/start/{start}/end/{end}</h4>
                    <pre>@RequestMapping(value="/api/site/{groupId}/collection/start/{start}/end/{end}",
                method=GET)
@ResponseStatus(value=OK)
@ResponseBody
public&nbsp;java.util.List&lt;java.util.Map&gt;&nbsp;siteSize(@PathVariable(value="groupId") long&nbsp;groupId,
                                                @PathVariable(value="start")   int start,
                                                @PathVariable(value="end")     int end)
                                   throws com.liferay.portal.kernel.exception.SystemException,
                                          com.liferay.portal.kernel.exception.PortalException</pre>
                    <div class="block">{groupId}의 모든 컬렉션을 처음과 끝부분 지정한 리스트</div>
                    <dl><dt><span class="strong">Parameters:</span></dt><dd><code>start</code> - </dd><dd><code>end</code> -
                        <dt><span class="strong">Returns:</span></dt>
                        <dd>List<map></map></dd>
                        <dt><span class="strong">Throws:</span></dt>
                        <dd><code>com.liferay.portal.kernel.exception.SystemException</code></dd>
                        <dd><code>com.liferay.portal.kernel.exception.PortalException</code></dd>
                    </dl>
                </li>
            </ul>
            <a name="collection()">
                <!--   -->
            </a>
            <ul class="blockList">
                <li class="blockList">
                    <h4>/rest/api/collection</h4>
                    <pre>@RequestMapping(value="/api/collection",
                method=GET)
@ResponseStatus(value=OK)
@ResponseBody
public&nbsp;java.util.List&lt;java.util.Map&gt;&nbsp;collection()
                                         throws com.liferay.portal.kernel.exception.SystemException</pre>
                    <div class="block">모든 컬렉션의 목록을 반환</div>
                    <dl><dt><span class="strong">Returns:</span></dt>
                        <dd>List<map></map></dd>
                        <dt><span class="strong">Throws:</span></dt>
                        <dd><code>com.liferay.portal.kernel.exception.SystemException</code></dd>
                    </dl>
                </li>
            </ul>
            <a name="collectionCount()">
                <!--   -->
            </a>
            <ul class="blockList">
                <li class="blockList">
                    <h4>/rest/api/collection/count</h4>
                    <pre>@RequestMapping(value="/api/collection/count",
                method=GET)
@ResponseStatus(value=OK)
@ResponseBody
public&nbsp;int&nbsp;collection()
            throws com.liferay.portal.kernel.exception.SystemException</pre>
                    <div class="block">모든 컬렉션의 목록의 개수 반환</div>
                    <dl><dt><span class="strong">Returns:</span></dt>
                        <dd>Integer<map></map></dd>
                        <dt><span class="strong">Throws:</span></dt>
                        <dd><code>com.liferay.portal.kernel.exception.SystemException</code></dd>
                    </dl>
                </li>
            </ul>
            <a name="collectionSize()">
                <!--   -->
            </a>
            <ul class="blockList">
                <li class="blockList">
                    <h4>/rest/api/collection/start/{start}/end/{end}</h4>
                    <pre>@RequestMapping(value="/api/collection/start/{start}/end/{end}",
                method=GET)
@ResponseStatus(value=OK)
@ResponseBody
public&nbsp;java.util.List&lt;java.util.Map&gt;&nbsp;collection(@PathVariable(value="start") int start,
                                                  @PathVariable(value="end")   int end)
                                         throws com.liferay.portal.kernel.exception.SystemException</pre>
                    <div class="block">모든 컬렉션의 목록을 처음과 끝부분 지정한 반환</div>
                    <dl><dt><span class="strong">Parameters:</span></dt><dd><code>start</code> - </dd><dd><code>end</code> -
                        <dt><span class="strong">Returns:</span></dt>
                        <dd>List<map></map></dd>
                        <dt><span class="strong">Throws:</span></dt>
                        <dd><code>com.liferay.portal.kernel.exception.SystemException</code></dd>
                    </dl>
                </li>
            </ul>
            <a name="collection(long)">
                <!--   -->
            </a>
            <ul class="blockList">
                <li class="blockList">
                    <h4>/rest/api/collection/{collectionId}</h4>
                    <pre>@RequestMapping(value="/api/collection/{collectionId}",
                method=GET)
@ResponseStatus(value=OK)
@ResponseBody
public&nbsp;java.util.Map&nbsp;collection(@PathVariable(value="collectionId")
                        long&nbsp;collectionId)
                         throws com.liferay.portal.kernel.exception.SystemException,
                                com.liferay.portal.kernel.exception.PortalException</pre>
                    <div class="block">{collectionId} 컬렉션의 메타데이터를 반환</div>
                    <dl><dt><span class="strong">Parameters:</span></dt>
                        <dd><code>collectionId</code> - </dd>
                        <dt><span class="strong">Returns:</span></dt>
                        <dd>Map</dd>
                        <dt><span class="strong">Throws:</span></dt>
                        <dd><code>com.liferay.portal.kernel.exception.SystemException</code></dd>
                        <dd><code>com.liferay.portal.kernel.exception.PortalException</code></dd>
                    </dl>
                </li>
            </ul>
            <a name="collectionDataset(long)">
                <!--   -->
            </a>
            <ul class="blockList">
                <li class="blockList">
                    <h4>/rest/api/collection/{collectionId}/dataset</h4>
                    <pre>@RequestMapping(value="/api/collection/{collectionId}/dataset",
                method=GET)
@ResponseStatus(value=OK)
@ResponseBody
public&nbsp;java.util.List&lt;java.util.Map&gt;&nbsp;collectionDataset(@PathVariable(value="collectionId")
                        long&nbsp;collectionId)
                        throws com.liferay.portal.kernel.exception.SystemException,
                        com.liferay.portal.kernel.exception.PortalException</pre>
                    <div class="block">{collectionId} 컬렉션의 모든 데이터셋의 목록을 반환</div>
                    <dl><dt><span class="strong">Parameters:</span></dt>
                        <dd><code>collectionId</code> - </dd>
                        <dt><span class="strong">Returns:</span></dt>
                        <dd>List<map></map></dd>
                        <dt><span class="strong">Throws:</span></dt>
                        <dd><code>com.liferay.portal.kernel.exception.SystemException</code></dd>
                        <dd><code>com.liferay.portal.kernel.exception.PortalException</code></dd>
                    </dl>
                </li>
            </ul>
            <a name="collectionDatasetPro(long)">
                <!--   -->
            </a>
            <ul class="blockList">
                <li class="blockList">
                    <h4>/rest/api/collection/{collectionId}/dataset{?property}</h4>
                    <pre>@RequestMapping(value="/api/collection/{collectionId}/dataset",
                method=GET)
@ResponseStatus(value=OK)
@ResponseBody
public&nbsp;java.util.List&lt;java.util.Map&gt;&nbsp;collectionDataset(@PathVariable(value="collectionId")long&nbsp;collectionId,
                                                         @RequestParam(required = false) String[] property)
                        throws com.liferay.portal.kernel.exception.SystemException,
                        com.liferay.portal.kernel.exception.PortalException</pre>
                    <div class="block">{collectionId} 컬렉션의 모든 데이터셋의 목록을 반환
                        <p>모든 자료가 아닌 해당 자료의 선택된 속성 만 요청하려면 속성 매개 변수를 다음 목록의 값과 함께 사용해야합니다:</p>
                        <div style="background-color: #f5f5f5;padding: 12px;border: 1px solid #cfcfcf;border-radius: 6px;overflow: auto;
                                    margin-bottom: 25px;margin-top: 25px;">
                            ['datasetId', 'title', 'descriptiveMetadata', 'provenanceMetadata', 'description', 'location', 'metalocation', 'groupId',
                            'companyId', 'userId', 'userName', 'createDate', 'publishDate', 'version', 'checksum', 'doi', 'remote', 'repository',
                            'fileFinalized', 'fileNum', 'hashcode', 'curateSignature', 'retrieveSignature', 'curateLogCode', 'curateLogDate',
                            'curateErrorCode', 'status', 'statusByUserId', 'statusByUserName', 'statusDate', 'collectionId', 'dataTypeId',
                            'ppLogicId', 'curateId', 'parent', 'grId' ]
                        </div>
                        <p><b>Example - Request:</b></p>
                        <div style="background-color: #f5f5f5;padding: 12px;border: 1px solid #cfcfcf;border-radius: 6px;overflow: auto;
                                    margin-bottom: 25px;margin-top: 25px;">

                            /rest/api/collection/{collectionId}/dataset?property=datasetId,title,description
                        </div>
                    </div>
                    <dl><dt><span class="strong">Parameters:</span></dt>
                        <dd><code>collectionId</code> - </dd>
                        <dd><code>property</code> - </dd>
                        <dt><span class="strong">Returns:</span></dt>
                        <dd>List<map></map></dd>
                        <dt><span class="strong">Throws:</span></dt>
                        <dd><code>com.liferay.portal.kernel.exception.SystemException</code></dd>
                        <dd><code>com.liferay.portal.kernel.exception.PortalException</code></dd>
                    </dl>
                </li>
            </ul>
            <a name="collectionDatasetCount(long)">
                <!--   -->
            </a>
            <ul class="blockList">
                <li class="blockList">
                    <h4>/rest/api/collection/{collectionId}/dataset/count</h4>
                    <pre>@RequestMapping(value="/api/collection/{collectionId}/dataset/count",
                method=GET)
@ResponseStatus(value=OK)
@ResponseBody
public&nbsp;int&nbsp;collectionDataset(@PathVariable(value="collectionId")
                        long&nbsp;collectionId)
                        throws com.liferay.portal.kernel.exception.SystemException,
                        com.liferay.portal.kernel.exception.PortalException</pre>
                    <div class="block">{collectionId} 컬렉션의 모든 데이터셋의 목록의 개수 반환</div>
                    <dl><dt><span class="strong">Parameters:</span></dt>
                        <dd><code>collectionId</code> - </dd>
                        <dt><span class="strong">Returns:</span></dt>
                        <dd>Integer</dd>
                        <dt><span class="strong">Throws:</span></dt>
                        <dd><code>com.liferay.portal.kernel.exception.SystemException</code></dd>
                        <dd><code>com.liferay.portal.kernel.exception.PortalException</code></dd>
                    </dl>
                </li>
            </ul>
            <a name="collectionDatasetSize(long)">
                <!--   -->
            </a>
            <ul class="blockList">
                <li class="blockList">
                    <h4>/rest/api/collection/{collectionId}/dataset/start/{start}/end/{end}</h4>
                    <pre>@RequestMapping(value="/api/collection/{collectionId}/dataset/start/{start}/end/{end}",
                method=GET)
@ResponseStatus(value=OK)
@ResponseBody
public&nbsp;java.util.List&lt;java.util.Map&gt;&nbsp;collectionDataset(@PathVariable(value="collectionId") long&nbsp;collectionId
                                                         @PathVariable(value="start")   int start,
                                                         @PathVariable(value="end")     int end)

                        throws com.liferay.portal.kernel.exception.SystemException,
                        com.liferay.portal.kernel.exception.PortalException</pre>
                    <div class="block">{collectionId} 컬렉션의 모든 데이터셋의 목록을 처음과 끝부분 지정한 반환</div>
                    <dl><dt><span class="strong">Parameters:</span></dt>
                        <dd><code>collectionId</code> - </dd>
                        <dd><code>start</code> - </dd><dd><code>end</code> -
                        <dt><span class="strong">Returns:</span></dt>
                        <dd>List<map></map></dd>
                        <dt><span class="strong">Throws:</span></dt>
                        <dd><code>com.liferay.portal.kernel.exception.SystemException</code></dd>
                        <dd><code>com.liferay.portal.kernel.exception.PortalException</code></dd>
                    </dl>
                </li>
            </ul>
            <a name="collectionDatasetSizePro(long)">
                <!--   -->
            </a>
            <ul class="blockList">
                <li class="blockList">
                    <h4>/rest/api/collection/{collectionId}/dataset/start/{start}/end/{end}{?property}</h4>
                    <pre>@RequestMapping(value="/api/collection/{collectionId}/dataset/start/{start}/end/{end}{?property}",
                method=GET)
@ResponseStatus(value=OK)
@ResponseBody
public&nbsp;java.util.List&lt;java.util.Map&gt;&nbsp;collectionDataset(@PathVariable(value="collectionId") long&nbsp;collectionId
                                                         @PathVariable(value="start")   int start,
                                                         @PathVariable(value="end")     int end,
                                                         @RequestParam(required = false) String[] property)

                        throws com.liferay.portal.kernel.exception.SystemException,
                        com.liferay.portal.kernel.exception.PortalException</pre>
                    <div class="block">{collectionId} 컬렉션의 모든 데이터셋의 목록을 처음과 끝부분 지정한 반환
                        <p>모든 자료가 아닌 해당 자료의 선택된 속성 만 요청하려면 속성 매개 변수를 다음 목록의 값과 함께 사용해야합니다:</p>
                        <div style="background-color: #f5f5f5;padding: 12px;border: 1px solid #cfcfcf;border-radius: 6px;overflow: auto;
                                    margin-bottom: 25px;margin-top: 25px;">
                            ['datasetId', 'title', 'descriptiveMetadata', 'provenanceMetadata', 'description', 'location', 'metalocation', 'groupId',
                            'companyId', 'userId', 'userName', 'createDate', 'publishDate', 'version', 'checksum', 'doi', 'remote', 'repository',
                            'fileFinalized', 'fileNum', 'hashcode', 'curateSignature', 'retrieveSignature', 'curateLogCode', 'curateLogDate',
                            'curateErrorCode', 'status', 'statusByUserId', 'statusByUserName', 'statusDate', 'collectionId', 'dataTypeId',
                            'ppLogicId', 'curateId', 'parent', 'grId' ]
                        </div>
                        <p><b>Example - Request:</b></p>
                        <div style="background-color: #f5f5f5;padding: 12px;border: 1px solid #cfcfcf;border-radius: 6px;overflow: auto;
                                    margin-bottom: 25px;margin-top: 25px;">

                            /rest/api/collection/{collectionId}/dataset/start/{start}/end/{end}?property=datasetId,title,description
                        </div>
                    </div>
                    <dl><dt><span class="strong">Parameters:</span></dt>
                        <dd><code>collectionId</code> - </dd>
                        <dd><code>start</code> - </dd><dd><code>end</code> -</dd>
                        <dd><code>property</code> - </dd>
                        <dt><span class="strong">Returns:</span></dt>
                        <dd>List<map></map></dd>
                        <dt><span class="strong">Throws:</span></dt>
                        <dd><code>com.liferay.portal.kernel.exception.SystemException</code></dd>
                        <dd><code>com.liferay.portal.kernel.exception.PortalException</code></dd>
                    </dl>
                </li>
            </ul>
            <a name="datatype()">
                <!--   -->
            </a>
            <ul class="blockList">
                <li class="blockList">
                    <h4>/rest/api/datatype</h4>
                    <pre>@RequestMapping(value="/api/datatype",
                method=GET)
@ResponseStatus(value=OK)
@ResponseBody
public&nbsp;java.util.List&lt;java.util.Map&gt;&nbsp;datatype()
                                       throws com.liferay.portal.kernel.exception.SystemException,
                                              com.liferay.portal.kernel.exception.PortalException</pre>
                    <div class="block">모든 데이터 타입의 목록을 반환</div>
                    <dl><dt><span class="strong">Returns:</span></dt>
                        <dd>List<map></map></dd>
                        <dt><span class="strong">Throws:</span></dt>
                        <dd><code>com.liferay.portal.kernel.exception.SystemException</code></dd>
                        <dd><code>com.liferay.portal.kernel.exception.PortalException</code></dd>
                    </dl>
                </li>
            </ul>
            <a name="datatypeCount()">
                <!--   -->
            </a>
            <ul class="blockList">
                <li class="blockList">
                    <h4>/rest/api/datatype/count</h4>
                    <pre>@RequestMapping(value="/api/datatype/count",
                method=GET)
@ResponseStatus(value=OK)
@ResponseBody
public&nbsp;int&nbsp;datatype()
                    throws com.liferay.portal.kernel.exception.SystemException,
                           com.liferay.portal.kernel.exception.PortalException</pre>
                    <div class="block">모든 데이터 타입의 목록의 개수 반환</div>
                    <dl><dt><span class="strong">Returns:</span></dt>
                        <dd>Integer</dd>
                        <dt><span class="strong">Throws:</span></dt>
                        <dd><code>com.liferay.portal.kernel.exception.SystemException</code></dd>
                        <dd><code>com.liferay.portal.kernel.exception.PortalException</code></dd>
                    </dl>
                </li>
            </ul>
            <a name="datatypeSize()">
                <!--   -->
            </a>
            <ul class="blockList">
                <li class="blockList">
                    <h4>/rest/api/datatype/start/{start}/end/{end}</h4>
                    <pre>@RequestMapping(value="/api/datatype/start/{start}/end/{end}",
                method=GET)
@ResponseStatus(value=OK)
@ResponseBody
public&nbsp;java.util.List&lt;java.util.Map&gt;&nbsp;datatype(@PathVariable(value="start")   int start,
                                                @PathVariable(value="end")     int end)
                                       throws com.liferay.portal.kernel.exception.SystemException,
                                              com.liferay.portal.kernel.exception.PortalException</pre>
                    <div class="block">모든 데이터 타입의 목록을 처음과 끝부분 지정한 반환</div>
                    <dl><dt><span class="strong">Parameters:</span></dt><dd><code>start</code> - </dd><dd><code>end</code> -
                        <dt><span class="strong">Returns:</span></dt>
                        <dd>List<map></map></dd>
                        <dt><span class="strong">Throws:</span></dt>
                        <dd><code>com.liferay.portal.kernel.exception.SystemException</code></dd>
                        <dd><code>com.liferay.portal.kernel.exception.PortalException</code></dd>
                    </dl>
                </li>
            </ul>
            <a name="dataType(long)">
                <!--   -->
            </a>
            <ul class="blockList">
                <li class="blockList">
                    <h4>/rest/api/datatype/{dataTypeId}</h4>
                    <pre>@RequestMapping(value="/api/datatype/{dataTypeId}",
                method=GET)
@ResponseStatus(value=OK)
@ResponseBody
public&nbsp;java.util.Map&nbsp;dataType(@PathVariable(value="dataTypeId")
                        long&nbsp;dataTypeId)
                       throws com.liferay.portal.kernel.exception.SystemException,
                              com.liferay.portal.kernel.exception.PortalException</pre>
                    <div class="block">{dataTypeId} 타입의 메타데이터를 반환</div>
                    <dl><dt><span class="strong">Parameters:</span></dt>
                        <dd><code>dataTypeId</code> - </dd>
                        <dt><span class="strong">Returns:</span></dt>
                        <dd>Map</dd>
                        <dt><span class="strong">Throws:</span></dt>
                        <dd><code>com.liferay.portal.kernel.exception.SystemException</code></dd>
                        <dd><code>com.liferay.portal.kernel.exception.PortalException</code></dd>
                    </dl>
                </li>
            </ul>
            <a name="dataset(long)">
                <!--   -->
            </a>
            <ul class="blockList">
                <li class="blockList">
                    <h4>/rest/api/dataset/{datasetId}</h4>
                    <pre>@RequestMapping(value="/api/dataset/{datasetId}",
                method=GET)
@ResponseStatus(value=OK)
@ResponseBody
public&nbsp;java.util.Map&nbsp;dataset(@PathVariable(value="datasetId")
                                                               long&nbsp;datasetId)
                      throws com.liferay.portal.kernel.exception.SystemException,
                             com.liferay.portal.kernel.exception.PortalException</pre>
                    <div class="block">{datasetId} 데이터셋의 메타데이터를 반환</div>
                    <dl><dt><span class="strong">Parameters:</span></dt>
                        <dd><code>datasetId</code> - </dd>
                        <dt><span class="strong">Returns:</span></dt>
                        <dd>Map</dd>
                        <dt><span class="strong">Throws:</span></dt>
                        <dd><code>com.liferay.portal.kernel.exception.SystemException</code></dd>
                        <dd><code>com.liferay.portal.kernel.exception.PortalException</code></dd>
                    </dl>
                </li>
            </ul>
            <a name="datasetPro(long)">
                <!--   -->
            </a>
            <ul class="blockList">
                <li class="blockList">
                    <h4>/rest/api/dataset/{datasetId}{?property}</h4>
                    <pre>@RequestMapping(value="/api/dataset/{datasetId}{?property}",
                method=GET)
@ResponseStatus(value=OK)
@ResponseBody
public&nbsp;java.util.Map&nbsp;dataset(@PathVariable(value="datasetId") long&nbsp;datasetId
                              @PathVariable(value="datasetId") long datasetId,
                              @RequestParam(required = false) String[] property)
                      throws com.liferay.portal.kernel.exception.SystemException,
                             com.liferay.portal.kernel.exception.PortalException</pre>
                    <div class="block">{datasetId} 데이터셋의 메타데이터를 반환
                        <p>모든 자료가 아닌 해당 자료의 선택된 속성 만 요청하려면 속성 매개 변수를 다음 목록의 값과 함께 사용해야합니다:</p>
                        <div style="background-color: #f5f5f5;padding: 12px;border: 1px solid #cfcfcf;border-radius: 6px;overflow: auto;
                                    margin-bottom: 25px;margin-top: 25px;">
                            ['datasetId', 'title', 'descriptiveMetadata', 'provenanceMetadata', 'description', 'location', 'metalocation', 'groupId',
                            'companyId', 'userId', 'userName', 'createDate', 'publishDate', 'version', 'checksum', 'doi', 'remote', 'repository',
                            'fileFinalized', 'fileNum', 'hashcode', 'curateSignature', 'retrieveSignature', 'curateLogCode', 'curateLogDate',
                            'curateErrorCode', 'status', 'statusByUserId', 'statusByUserName', 'statusDate', 'collectionId', 'dataTypeId',
                            'ppLogicId', 'curateId', 'parent', 'grId' ]
                        </div>
                        <p><b>Example - Request:</b></p>
                        <div style="background-color: #f5f5f5;padding: 12px;border: 1px solid #cfcfcf;border-radius: 6px;overflow: auto;
                                    margin-bottom: 25px;margin-top: 25px;">

                            /rest/api/dataset/{datasetId}?property=datasetId,title,description
                        </div>
                    </div>
                    <dl><dt><span class="strong">Parameters:</span></dt>
                        <dd><code>datasetId</code> - </dd>
                        <dd><code>property</code> - </dd>
                        <dt><span class="strong">Returns:</span></dt>
                        <dd>Map</dd>
                        <dt><span class="strong">Throws:</span></dt>
                        <dd><code>com.liferay.portal.kernel.exception.SystemException</code></dd>
                        <dd><code>com.liferay.portal.kernel.exception.PortalException</code></dd>
                    </dl>
                </li>
            </ul>
            <a name="datasetFile(long)">
                <!--   -->
            </a>
            <ul class="blockList">
                <li class="blockList">
                    <h4>/rest/api/dataset/{datasetId}/file</h4>
                    <pre>@RequestMapping(value="/api/dataset/{datasetId}/file",
                method=GET)
@ResponseStatus(value=OK)
@ResponseBody
public&nbsp;java.util.List&lt;java.util.Map&gt;&nbsp;datasetFile(@PathVariable(value="datasetId")
                        long&nbsp;datasetId)
                                          throws com.liferay.portal.kernel.exception.SystemException,
                                                 com.liferay.portal.kernel.exception.PortalException</pre>
                    <div class="block">{datasetId} 데이터셋의 파일 리스트를 반환</div>
                    <dl><dt><span class="strong">Parameters:</span></dt>
                        <dd><code>datasetId</code> - </dd>
                        <dt><span class="strong">Returns:</span></dt>
                        <dd>List<map></map></dd>
                        <dt><span class="strong">Throws:</span></dt>
                        <dd><code>com.liferay.portal.kernel.exception.SystemException</code></dd>
                        <dd><code>com.liferay.portal.kernel.exception.PortalException</code></dd>
                    </dl>
                </li>
            </ul>
            <a name="datasetFilePro(long)">
            <!--   -->
            </a>
            <ul class="blockList">
                <li class="blockList">
                    <h4>/rest/api/dataset/{datasetId}/file{?property}</h4>
                    <pre>@RequestMapping(value="/api/dataset/{datasetId}/file{?property}",
                method=GET)
@ResponseStatus(value=OK)
@ResponseBody
public&nbsp;java.util.List&lt;java.util.Map&gt;&nbsp;datasetFile(@PathVariable(value="datasetId") long&nbsp;datasetId,
                                                    @RequestParam(required = false) String[] property)
                                          throws com.liferay.portal.kernel.exception.SystemException,
                                                 com.liferay.portal.kernel.exception.PortalException</pre>
                    <div class="block">{datasetId} 데이터셋의 파일 리스트를 반환
                        <p>모든 자료가 아닌 해당 자료의 선택된 속성 만 요청하려면 속성 매개 변수를 다음 목록의 값과 함께 사용해야합니다:</p>
                        <div style="background-color: #f5f5f5;padding: 12px;border: 1px solid #cfcfcf;border-radius: 6px;overflow: auto;
                                    margin-bottom: 25px;margin-top: 25px;">
                            ['datasetId', 'title', 'descriptiveMetadata', 'provenanceMetadata', 'description', 'location', 'metalocation', 'groupId',
                            'companyId', 'userId', 'userName', 'createDate', 'publishDate', 'version', 'checksum', 'doi', 'remote', 'repository',
                            'fileFinalized', 'fileNum', 'hashcode', 'curateSignature', 'retrieveSignature', 'curateLogCode', 'curateLogDate',
                            'curateErrorCode', 'status', 'statusByUserId', 'statusByUserName', 'statusDate', 'collectionId', 'dataTypeId',
                            'ppLogicId', 'curateId', 'parent', 'grId' ]
                        </div>
                        <p><b>Example - Request:</b></p>
                        <div style="background-color: #f5f5f5;padding: 12px;border: 1px solid #cfcfcf;border-radius: 6px;overflow: auto;
                                    margin-bottom: 25px;margin-top: 25px;">

                            /rest/api/dataset/{datasetId}?property=datasetId,title,description
                        </div>
                    </div>
                    <dl><dt><span class="strong">Parameters:</span></dt>
                        <dd><code>datasetId</code> - </dd>
                        <dd><code>property</code> - </dd>
                        <dt><span class="strong">Returns:</span></dt>
                        <dd>List<map></map></dd>
                        <dt><span class="strong">Throws:</span></dt>
                        <dd><code>com.liferay.portal.kernel.exception.SystemException</code></dd>
                        <dd><code>com.liferay.portal.kernel.exception.PortalException</code></dd>
                    </dl>
                </li>
            </ul>
            <a name="datasetFileCount(long)">
                <!--   -->
            </a>
            <ul class="blockList">
                <li class="blockList">
                    <h4>/rest/api/dataset/{datasetId}/file/count</h4>
                    <pre>@RequestMapping(value="/api/dataset/{datasetId}/file/count",
                method=GET)
@ResponseStatus(value=OK)
@ResponseBody
public&nbsp;int&nbsp;datasetFile(@PathVariable(value="datasetId")
                        long&nbsp;datasetId)
                                          throws com.liferay.portal.kernel.exception.SystemException,
                                                 com.liferay.portal.kernel.exception.PortalException</pre>
                    <div class="block">{datasetId} 데이터셋의 파일 리스트의 개수 반환</div>
                    <dl><dt><span class="strong">Parameters:</span></dt>
                        <dd><code>datasetId</code> - </dd>
                        <dt><span class="strong">Returns:</span></dt>
                        <dd>Integer</dd>
                        <dt><span class="strong">Throws:</span></dt>
                        <dd><code>com.liferay.portal.kernel.exception.SystemException</code></dd>
                        <dd><code>com.liferay.portal.kernel.exception.PortalException</code></dd>
                    </dl>
                </li>
            </ul>
            <a name="datasetFileSize(long)">
                <!--   -->
            </a>
            <ul class="blockList">
                <li class="blockList">
                    <h4>/rest/api/dataset/{datasetId}/file/start/{start}/end/{end}</h4>
                    <pre>@RequestMapping(value="/api/dataset/{datasetId}/file/start/{start}/end/{end}",
                method=GET)
@ResponseStatus(value=OK)
@ResponseBody
public&nbsp;java.util.List&lt;java.util.Map&gt;&nbsp;datasetFile(@PathVariable(value="datasetId") long&nbsp;datasetId),
                                                   @PathVariable(value="start")   int start,
                                                   @PathVariable(value="end")     int end
                                          throws com.liferay.portal.kernel.exception.SystemException,
                                                 com.liferay.portal.kernel.exception.PortalException</pre>
                    <div class="block">{datasetId} 데이터셋의 파일 리스트를 처음과 끝부분 지정한 반환</div>
                    <dl><dt><span class="strong">Parameters:</span></dt>
                        <dd><code>datasetId</code> - </dd>
                        <dd><code>start</code> - </dd><dd><code>end</code> -
                        <dt><span class="strong">Returns:</span></dt>
                        <dd>List<map></map></dd>
                        <dt><span class="strong">Throws:</span></dt>
                        <dd><code>com.liferay.portal.kernel.exception.SystemException</code></dd>
                        <dd><code>com.liferay.portal.kernel.exception.PortalException</code></dd>
                    </dl>
                </li>
            </ul>
            <a name="datasetFileSizePro(long)">
                <!--   -->
            </a>
            <ul class="blockList">
                <li class="blockList">
                    <h4>/rest/api/dataset/{datasetId}/file/start/{start}/end/{end}{?property}</h4>
                    <pre>@RequestMapping(value="/api/dataset/{datasetId}/file/start/{start}/end/{end}{?property}",
                method=GET)
@ResponseStatus(value=OK)
@ResponseBody
public&nbsp;java.util.List&lt;java.util.Map&gt;&nbsp;datasetFile(@PathVariable(value="datasetId") long&nbsp;datasetId),
                                                   @PathVariable(value="start")   int start,
                                                   @PathVariable(value="end")     int end,
                                                   @RequestParam(required = false) String[] property
                                          throws com.liferay.portal.kernel.exception.SystemException,
                                                 com.liferay.portal.kernel.exception.PortalException</pre>
                    <div class="block">{datasetId} 데이터셋의 파일 리스트를 처음과 끝부분 지정한 반환
                        <p>모든 자료가 아닌 해당 자료의 선택된 속성 만 요청하려면 속성 매개 변수를 다음 목록의 값과 함께 사용해야합니다:</p>
                        <div style="background-color: #f5f5f5;padding: 12px;border: 1px solid #cfcfcf;border-radius: 6px;overflow: auto;
                                    margin-bottom: 25px;margin-top: 25px;">
                            ['datasetId', 'title', 'descriptiveMetadata', 'provenanceMetadata', 'description', 'location', 'metalocation', 'groupId',
                            'companyId', 'userId', 'userName', 'createDate', 'publishDate', 'version', 'checksum', 'doi', 'remote', 'repository',
                            'fileFinalized', 'fileNum', 'hashcode', 'curateSignature', 'retrieveSignature', 'curateLogCode', 'curateLogDate',
                            'curateErrorCode', 'status', 'statusByUserId', 'statusByUserName', 'statusDate', 'collectionId', 'dataTypeId',
                            'ppLogicId', 'curateId', 'parent', 'grId' ]
                        </div>
                        <p><b>Example - Request:</b></p>
                        <div style="background-color: #f5f5f5;padding: 12px;border: 1px solid #cfcfcf;border-radius: 6px;overflow: auto;
                                    margin-bottom: 25px;margin-top: 25px;">

                            /rest/api/dataset/{datasetId}?property=datasetId,title,description
                        </div>
                    </div>
                    <dl><dt><span class="strong">Parameters:</span></dt>
                        <dd><code>datasetId</code> - </dd>
                        <dd><code>start</code> - </dd><dd><code>end</code> -</dd>
                        <dd><code>property</code> - </dd>
                        <dt><span class="strong">Returns:</span></dt>
                        <dd>List<map></map></dd>
                        <dt><span class="strong">Throws:</span></dt>
                        <dd><code>com.liferay.portal.kernel.exception.SystemException</code></dd>
                        <dd><code>com.liferay.portal.kernel.exception.PortalException</code></dd>
                    </dl>
                </li>
            </ul>





            <a name="search">
                <!--   -->
            </a>
            <ul class="blockList">
                <li class="blockList">
                    <h4>/rest/api/search/{condition}</h4>
                    <pre>@RequestMapping(value="/api/search/{condition}",
                method=GET)
@ResponseStatus(value=OK)
@ResponseBody
public&nbsp;java.util.List&lt;java.util.Map&gt;&nbsp;search(@PathVariable(value="condition")
                                      java.lang.String&nbsp;condition)
                                     throws com.liferay.portal.kernel.exception.SystemException,
                                            com.liferay.portal.kernel.exception.PortalException</pre>
                    <div class="block">{condition}의 검색조건으로 Advanced Search</div>
                    <dl><dt><span class="strong">Parameters:</span></dt><dd><code>condition</code> - </dd>
                        <dt><span class="strong">Returns:</span></dt><dd></dd>
                        <dt><span class="strong">Throws:</span></dt>
                        <dd><code>com.liferay.portal.kernel.exception.SystemException</code></dd>
                        <dd><code>com.liferay.portal.kernel.exception.PortalException</code></dd></dl>
                </li>
            </ul>
            <a name="searchCount">
                <!--   -->
            </a>
            <ul class="blockList">
                <li class="blockList">
                    <h4>/rest/api/search/{condition}/count</h4>
                    <pre>@RequestMapping(value="/api/search/{condition}/count",
                method=GET)
@ResponseStatus(value=OK)
@ResponseBody
public&nbsp;int&nbsp;search(@PathVariable(value="condition")
                                      java.lang.String&nbsp;condition)
                                     throws com.liferay.portal.kernel.exception.SystemException,
                                            com.liferay.portal.kernel.exception.PortalException</pre>
                    <div class="block">{condition}의 검색조건으로 Advanced Search의 개수</div>
                    <dl><dt><span class="strong">Parameters:</span></dt><dd><code>condition</code> - </dd>
                        <dt><span class="strong">Returns:</span></dt><dd></dd>
                        <dt><span class="strong">Throws:</span></dt>
                        <dd><code>com.liferay.portal.kernel.exception.SystemException</code></dd>
                        <dd><code>com.liferay.portal.kernel.exception.PortalException</code></dd></dl>
                </li>
            </ul>
            <a name="searchSize">
                <!--   -->
            </a>
            <ul class="blockList">
                <li class="blockList">
                    <h4>/rest/api/search/{condition}/start/{start}/end/{end}</h4>
                    <pre>@RequestMapping(value="/api/search/{condition}/start/{start}/end/{end}",
                method=GET)
@ResponseStatus(value=OK)
@ResponseBody
public&nbsp;java.util.List&lt;java.util.Map&gt;&nbsp;search(@PathVariable(value="condition") java.lang.String&nbsp;condition
                                              @PathVariable(value="start")   int start,
                                              @PathVariable(value="end")     int end)
                                     throws com.liferay.portal.kernel.exception.SystemException,
                                            com.liferay.portal.kernel.exception.PortalException</pre>
                    <div class="block">{condition}의 검색조건으로 Advanced Search를 처음과 끝부분 지정한 리스트</div>
                    <dl><dt><span class="strong">Parameters:</span></dt>
                        <dd><code>condition</code> - </dd>
                        <dd><code>start</code> - </dd><dd><code>end</code> -
                        <dt><span class="strong">Returns:</span></dt><dd></dd>
                        <dt><span class="strong">Throws:</span></dt>
                        <dd><code>com.liferay.portal.kernel.exception.SystemException</code></dd>
                        <dd><code>com.liferay.portal.kernel.exception.PortalException</code></dd></dl>
                </li>
            </ul>


            <a name="searchDataType">
                <!--   -->
            </a>
            <ul class="blockList">
                <li class="blockList">
                    <h4>/rest/api/search/{condition}/datatype/{datatype}</h4>
                    <pre>@RequestMapping(value="/api/search/{condition}/datatype/{datatype}",
                method=GET)
@ResponseStatus(value=OK)
@ResponseBody
public&nbsp;java.util.List&lt;java.util.Map&gt;&nbsp;search_site(@PathVariable(value="condition")
                                          java.lang.String&nbsp;condition),
                                          @PathVariable(value="datatype")
                                            java.lang.String&nbsp;datatype
                                          throws com.liferay.portal.kernel.exception.SystemException,
                                                 com.liferay.portal.kernel.exception.PortalException</pre>
                    <div class="block">{datatype}별 {condition}의 검색조건으로 Advanced Search</div>
                    <dl><dt><span class="strong">Parameters:</span></dt><dd><code>condition</code> - </dd><dd><code>datatype</code> - </dd>
                        <dt><span class="strong">Returns:</span></dt><dd></dd>
                        <dt><span class="strong">Throws:</span></dt>
                        <dd><code>com.liferay.portal.kernel.exception.SystemException</code></dd>
                        <dd><code>com.liferay.portal.kernel.exception.PortalException</code></dd></dl>
                </li>
            </ul>


            <a name="datasetFile_down">
                <!--   -->
            </a>
            <ul class="blockList">
                <li class="blockList">
                    <h4>/rest/api/file/dataset/{datasetId}</h4>
                    <pre>@RequestMapping(value="/api/file/dataset/{datasetId}",
                method=GET)
@ResponseStatus(value=OK)
public&nbsp;void&nbsp;datasetFile(@PathVariable(value="datasetId")
                                             long&nbsp;datasetId,
                                             javax.servlet.http.HttpServletRequest&nbsp;request,
                                             javax.servlet.http.HttpServletResponse&nbsp;response)
                 throws com.liferay.portal.kernel.exception.SystemException,
                        java.io.IOException,
                        com.liferay.portal.kernel.exception.PortalException</pre>
                    <div class="block">{datasetId} 파일을 다운로드</div>
                    <dl><dt><span class="strong">Parameters:</span></dt>
                        <dd><code>datasetId</code> - </dd>
                        <dd><code>request</code> - </dd>
                        <dd><code>response</code> - </dd>
                        <dt><span class="strong">Returns:</span></dt>
                        <dd>File</dd>
                        <dt><span class="strong">Throws:</span></dt>
                        <dd><code>com.liferay.portal.kernel.exception.SystemException</code></dd>
                        <dd><code>java.io.IOException</code></dd>
                        <dd><code>com.liferay.portal.kernel.exception.PortalException</code></dd>
                    </dl>
                </li>
            </ul>
            <a name="datasetFilePath_down">
                <!--   -->
            </a>
            <ul class="blockListLast">
                <li class="blockList">
                    <h4>/rest/api/file/dataset/{datasetId}/path/{FileName}</h4>
                    <pre>@RequestMapping(value="/api/file/dataset/{datasetId}/path/**",
                method=GET)
@ResponseStatus(value=OK)
public&nbsp;void&nbsp;datasetFilePath(@PathVariable(value="datasetId")
                                                 long&nbsp;datasetId,
                                                 javax.servlet.http.HttpServletRequest&nbsp;request,
                                                 javax.servlet.http.HttpServletResponse&nbsp;response)
                     throws com.liferay.portal.kernel.exception.SystemException,
                            java.io.IOException,
                            com.liferay.portal.kernel.exception.PortalException</pre>
                    <div class="block">{datasetId}의 {FileName} 파일을 다운로드</div>
                    <dl><dt><span class="strong">Parameters:</span></dt>
                        <dd><code>datasetId</code> - </dd>
                        <dd><code>request</code> - </dd>
                        <dd><code>response</code> - </dd>
                        <dt><span class="strong">Returns:</span></dt>
                        <dd>File</dd>
                        <dt><span class="strong">Throws:</span></dt>
                        <dd><code>com.liferay.portal.kernel.exception.SystemException</code></dd>
                        <dd><code>java.io.IOException</code></dd>
                        <dd><code>com.liferay.portal.kernel.exception.PortalException</code></dd>
                    </dl>
                </li>
            </ul>
        </div>

    </div>