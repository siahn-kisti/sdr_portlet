'''
# GUI based automatic Python code generator for Machine Learning

implemented by Jeongcheol Lee
0% ver 0.05 @ 2018. 8. 22. -


'''

##############################################################################################

def from_gui_to_code(gui_params):
    prev = ""
    body = ""
    post = ""
    if gui_params:	# if it exists
        prev = getImportingList()+getDataLoading(gui_params)
        body = getAlgorithmBody(gui_params)
        post = getEvaluation(gui_params)
    return prev+"\n"+body+"\n"+post

##############################################################################################

def getImportingList():
    default = '''#-*- encoding: utf-8 -*-
import numpy as np
import pandas as pd
import seaborn as sns
import sklearn.metrics as metrics
import matplotlib.pyplot as plt
%matplotlib inline
'''
#from matplotlib import style

    return default + "\n"

def getDataLoading(gui_params):
    flag = ""
    data_loading = '''##* Data Loading
all_data = pd.read_csv("'''+ gui_params['ml_file_path'] + gui_params['ml_file_name'] +'''")

## Discover the head of your data
all_data.head()

'''
    pre_processing_imputation = '''##* Pre-processing - 1. Inpute Missing values
## There are many options in order to deal with a missing value such as:
## - A constant value that has meaning within the domain, such as 0, distinct from all other values.
## - A value from another randomly selected record.
## - A mean, median or mode value for the column.
## - A value estimated by another predictive model.
## We are going to replace a missing value to 0.

## Filling 0 for missing values
all_data.fillna(0, inplace=True)

'''
    pre_processing_vectorization = '''##* Pre-processing - 2. Vectorization
''' + doVectorization(gui_params) 

    train_test_split = '''##* Train and Test Dataset Split
'''
    if gui_params['testing_frame_extract_method'] == 'random':
        flag = "True"
    elif gui_params['testing_frame_extract_method'] == 'basic':
        flag = "False"

    train_test_split = train_test_split + "from sklearn.model_selection import train_test_split\ntrain_data, test_data = train_test_split(all_data, test_size = " + str(gui_params['testing_frame_rate']) + ", shuffle = " + flag + ")\n"

    # getting column names
    input_cols, output_col, input_index_list, output_index = getInputOutputColumnNames(gui_params)

    # getting Train_Xy and Test_Xy
#    X_train = "origin_X_train = " + getTrainXyTestXyarray(input_cols, "train_data")
#    X_test = "origin_X_test = " + getTrainXyTestXyarray(input_cols, "test_data")
#    y_train = "y_train = " + getTrainXyTestXyarray(output_col, "train_data")
#    y_test = "y_test = " + getTrainXyTestXyarray(output_col, "test_data")
#    train_test_split = train_test_split + "\n##* get X_train, X_test, y_train, y_test\n"+X_train+X_test+y_train+y_test + "\n"

    ## data normalization or standarization, here we use standarization
#    norm_or_std = "##* Normalization/Standarization: Data arange scaling by using MinMaxScaler\nfrom sklearn.preprocessing import MinMaxScaler\nscaler = MinMaxScaler(feature_range=(0,1))\n"
#    norm_or_std = norm_or_std + "X_train = scaler.fit_transform(origin_X_train)\nX_test = scaler.fit_transform(origin_X_test)\n"
#    return data_loading +pre_processing_imputation+pre_processing_vectorization + "\n"+ train_test_split + norm_or_std

#    converted_input_cols=[]
#    for item in input_cols:
#        converted_input_cols.append(str("'"+input_cols+"'"))
    
    if type(input_cols) is list:
        input_cols_string = ', '.join('{!r}'.format(item) for item in input_cols)
    else:
        input_cols_string = input_cols    

    data_analysis = "\n##* Dataset Analysis\ncolumn_list = ['"+ output_col +"', " + input_cols_string + "]\nfeatures = [" + input_cols_string + "]\ntarget = '" + output_col + "'\n"
    data_analysis = data_analysis + "\n##* Correlation among all columns in all_data\nall_corr = all_data.corr()\nfig, ax = plt.subplots(figsize=(8,6))\nsns.heatmap(all_corr)\n"
    data_analysis = data_analysis + "\n##* Correlation among input columns regarding the target column in train_data\ncorr = train_data[column_list].corr()[target].abs()\nprint(corr)\nmax_corr = corr.drop(target).idxmax()\t# get the highest correlated column regarding the target column\nsns.lmplot(x = max_corr, y = target, data = train_data)\n"

    #train_data[column_list].corr()[target]\nfig, ax = plt.subplots(figsize=(8,6))\nsns.heatmap(corr)"
    return data_loading +pre_processing_imputation+pre_processing_vectorization + "\n"+ train_test_split + data_analysis

def getAlgorithmBody(gui_params):
    results = ""
# 20180801 The 'task' parameter is included into algorithm functions
#    if gui_params['task'] == 'Regression':
#        if gui_params['algorithm'] == 'MLR':
#            results = getMultipleLinearRegression(gui_params)
#        elif gui_params['algorithm'] == 'SVM':
#            results = getSupportVectorRegression(gui_params)
#        elif gui_params['algorithm'] == 'RF':
#            results = getRandomForest(gui_params)
#        elif gui_params['algorithm'] == 'BT':
#            results = getBoostedTrees(gui_params)
#        elif gui_params['algorithm'] == 'LR':
#            results = getLocalRegression(gui_params)
#        elif gui_params['algorithm'] == 'DL':
#            results = getDeepLearning(gui_params)
#    elif gui_params['task'] == 'Classification':
#        if gui_params['algorithm'] == 'SVM':
#            results = get
    if gui_params['algorithm'] == 'MLR':
        results = getMultipleLinearRegression(gui_params)
    elif gui_params['algorithm'] == 'SVM':
        results = getSupportVectorMachine(gui_params)
    elif gui_params['algorithm'] == 'RF':
        results = getRandomForest(gui_params)
    elif gui_params['algorithm'] == 'BT':
        results = getBoostedTrees(gui_params)
    elif gui_params['algorithm'] == 'LR':
        results = getLocalRegression(gui_params)
    elif gui_params['algorithm'] == 'DL':
        results = getDeepLearning(gui_params)
    
    elif gui_params['task'] == 'Classificatin':
        if gui_params['algorithm'] == 'SVM':
            pass

    return results

def getEvaluation(gui_params):
    results = ""
    if gui_params['analysis']  is not None:
        results = results + getAdditionalAnalyticResults(gui_params)
    if gui_params['perf_eval'] is not None:
        results = results + "\n##* Performance Evaluation\n" + getPerformanceEvaluationResults(gui_params)
    return results

def doVectorization(gui_params):
    header = ""
    results = ""
    set_of_lb = ""
    show_summary_heads = ""
    column_name = ""
    replaced_column_name = ""
    drop_original_column = ""
    add_binarized_columns = ""
    drop_original_column_and_add_binarized_columns = ""
    
    for column_index in gui_params['datatype_of_columns']:
        if gui_params['datatype_of_columns'][column_index] == 'Numeric':
            pass
        elif gui_params['datatype_of_columns'][column_index] == 'String' or 'Boolean' or 'Date':
            header = "## Keep the original data frame\nall_data_old = all_data\n\n## using Label Binarizer from the sklearn package\nfrom sklearn.preprocessing import LabelBinarizer\n"
            # replace '.' -> '_' for python            
            column_name = gui_params['whole_columns_index_and_name'][column_index]
            replaced_column_name = column_name.replace(".","_") + "_lb"
            set_of_lb = "\n## For the categorical column '" + column_name + "'\n" + replaced_column_name + " = LabelBinarizer()\n" + replaced_column_name + " = " + replaced_column_name + '.fit_transform(all_data["' + column_name + '"])\n'
            drop_original_column = "# drop original column and add binarized columns\nall_data = all_data.drop(columns=['" + column_name + "'])\n"
            add_binarized_columns = "column_names = []\nfor i in range(0, " + replaced_column_name + '.shape[1]):\n    column_names.append("' + column_name + '"+"_types_"+str(i+1))\n' + 'temp = pd.DataFrame(' + replaced_column_name + ", columns = column_names)\n" + "all_data = pd.concat([all_data, temp], axis=1)\n"
            results = results + set_of_lb + drop_original_column + add_binarized_columns
    if results == "":
    	results = "## Numeric data only. There is nothing to be vectorized.\n"
    show_summary_heads = "\n## Converted data frame\nall_data.head()\n"
    return header+results + show_summary_heads

def getInputOutputColumnNames(gui_params):
    output_col = ""
    input_cols = []

    input_index_list = []
    output_index = ""

    for index in gui_params['output_columns_index_and_name']:
        output_col = gui_params['output_columns_index_and_name'][index]
        output_index = int(index)
    for index in gui_params['input_columns_index_and_name']:
        input_cols.append(gui_params['input_columns_index_and_name'][index])
        input_index_list.append(int(index))

    return input_cols, output_col, input_index_list, output_index
                   
def getExceptionalHyperParameters(gui_params):
    inner_options_list=[]
    inner_options_string=""
    #annotate_list_list=[]
    #annotate_list_string=""
    
    for hparam in gui_params['hparams']:
        if gui_params['algorithm'] == 'LR':
            if hparam == 'nn':
                #annotate_list.append("nn")
                inner_options_list.append("nn = "+str(gui_params['hparams'][hparam]))
            elif hparam == 'scale':
            	#annotate_list.append("scale")
            	inner_options_list.append("scale = "+str(gui_params['hparams'][hparam]))
        # generate strings through option and annotation lists
        if inner_options_list:
            inner_options_string = ", " + ", ".join(inner_options_list)
        #if annotate_list:
        #    annotate_list_string = "\t# " + ", ".join(annotate_list)
    return inner_options_string

def getHyperParametersandClosing(gui_params):
    results = ""
    options_and_close = ")\n"
    python_cv_template = '''
##* K-fold cross validation
from sklearn.model_selection import KFold

kf = KFold(n_splits=2, random_state=None, shuffle=False)





'''
    if gui_params['hparams']:	# if it exists
        inner_options_list = []
        inner_options_string=""

        annotate_list = []
        annotate_list_string=""

        outer_options_list=[]
        outer_options_string=""
        for hparam in gui_params['hparams']:
            
            if gui_params['algorithm'] == 'MLR':
                if hparam == 'cv':
                    annotate_list.append("k-fold cross-validation is currently not supported.")
                    outer_options_list.append("")
                outer_options_string = "\n".join(outer_options_list)
            
            elif gui_params['algorithm'] == 'SVM':
                if hparam == 'cv':
                    annotate_list.append("k-fold cross-validation")
                    inner_options_list.append("cross = " + str(gui_params['hparams'][hparam]))
                elif hparam == 'kernel':
                    annotate_list.append("svm kernel select") #'linear', 'polynomial', 'radial', and 'sigmoid'
                    inner_options_list.append('kernel = "'+ str(gui_params['hparams'][hparam])+'"')

            elif gui_params['algorithm'] == 'RF':
                if hparam == 'ntrees':
                    annotate_list.append("total number of trees to fit")
                    inner_options_list.append("ntree = "+ str(gui_params['hparams'][hparam]))

            elif gui_params['algorithm'] == 'BT':
                if hparam == 'cv':
                    annotate_list.append("k-fold cross-validation")
                    inner_options_list.append("cv.folds = " + str(gui_params['hparams'][hparam]))
                elif hparam == 'ntrees':
                    annotate_list.append("total number of trees to fit")
                    inner_options_list.append("n.trees = "+ str(gui_params['hparams'][hparam]))

            elif gui_params['algorithm'] == 'LR':
                #nothing to do
                pass

            elif gui_params['algorithm'] == 'DL':
                if hparam == 'cv':
                    annotate_list.append("k-fold cross-validation")
                    inner_options_list.append("nfolds = "+ str(gui_params['hparams'][hparam]))
                elif hparam == 'epochs':
                    annotate_list.append("dataset iteration number")
                    inner_options_list.append("epochs = "+ str(gui_params['hparams'][hparam]))
                elif hparam == 'hidden':
                    annotate_list.append("hidden layer network design")
                    inner_options_list.append("hidden = c(" + str(gui_params['hparams'][hparam]) + ")")

            #######################################
            # common options - custom options
            if hparam == 'custom':
                annotate_list.append("custom options")
                inner_options_list.append(str(gui_params['hparams'][hparam]))

            # generate strings through option and annotation lists
            if inner_options_list:
            	inner_options_string = ", " + ", ".join(inner_options_list)

            if annotate_list:
                annotate_list_string = "\t# " + ", ".join(annotate_list)
            #######################################
        return inner_options_string + options_and_close + outer_options_string + annotate_list_string + "\n\n"
    else:
        return options_and_close + "\n"

def getTrainXyTestXyarray(column_name_list, which_data):
    begin = "np.c_["
    intermediate = ""
    converted = list()
    
    if type(column_name_list) is list:
        for item in column_name_list:
            converted.append(which_data+"['"+item+"']") # ex) item == thickness -> train_data['thickness']
        intermediate = ", ".join(converted)
    else:
        intermediate = which_data + "['" + column_name_list + "']"
    end = "]"
    return begin+intermediate+end + "\n"


##############################################################################################
##  Algorithms
##############################################################################################

def getMultipleLinearRegression(gui_params):
    # getting column names
    input_cols, output_col, input_index_list, output_index = getInputOutputColumnNames(gui_params)

    # algorithm part
    results = "##* Multiple Linear Regression\nfrom sklearn.linear_model import LinearRegression\nmlr = LinearRegression()\nmlr.fit(train_data[features], train_data[target])\n"

    #getHyperParametersandClosing(gui_params)
    
    results = results + "\n"+ getDefaultParametersDetails(gui_params) # describing default values of mandantory hyperparameters

    results = results + '''##* results
print(mlr)\t# We used the MinMax Scaler, instead of normalization options in the LinearRegression().

##* Predict using the model we made.
predicted = mlr.predict(test_data[features])
confidence = mlr.score(test_data[features], test_data[target])
print("Prediction accuracy: ", confidence)
'''
    results = results + getBasicAnalyticGraph(output_col, gui_params['task'])
    return results

def getSupportVectorMachine(gui_params):
    # getting column names
    input_cols, output_col, input_index_list, output_index = getInputOutputColumnNames(gui_params)

    # title
    if gui_params['task'] == 'Regression':
        results = "##* Support Vector Regression\n"
    elif gui_params['task'] == 'Classification':
        results = "##* Support Vector Classification\n"

    # code body # svm has the same code between regression and classification
    results = results + '''library(e1071)
model = svm(formula = ''' + output_col + " ~ " + " + ".join(input_cols) + ", data = train_data" + getHyperParametersandClosing(gui_params)

    results = results + getDefaultParametersDetails(gui_params) # describing default values of mandantory hyperparameters

    results = results + '''##* results
print(mlr)\t# if you want to use 

##* Predict using the model we made.
predicted = predict(model, newdata = test_data)
'''
    results = results + getBasicAnalyticGraph(output_col, gui_params['task'])    
    return results

def getRandomForest(gui_params):
    # getting column names
    input_cols, output_col, input_index_list, output_index = getInputOutputColumnNames(gui_params)
    
    results = "##* Random Forests\n"

    results = results + '''library(randomForest)
model = randomForest(formula = ''' + output_col + " ~ " + " + ".join(input_cols) + ", data = train_data" + getHyperParametersandClosing(gui_params)

    results = results + getDefaultParametersDetails(gui_params) # describing default values of mandantory hyperparameters

    results = results + '''##* results
print(model)

##* Predict using the model we made.
predicted = predict(model, newdata = test_data)
'''
    results = results + getBasicAnalyticGraph(output_col, gui_params['task'])
    return results

def getBoostedTrees(gui_params):
    # getting column names
    input_cols, output_col, input_index_list, output_index = getInputOutputColumnNames(gui_params)
    
    results = "##* Generalized Boosted Regression (boosted trees)\n"

    results = results + '''library(gbm)
model = gbm(formula = ''' + output_col + " ~ " + " + ".join(input_cols) + ", data = train_data" + getHyperParametersandClosing(gui_params)

    results = results + getDefaultParametersDetails(gui_params) # describing default values of mandantory hyperparameters

    results = results + '''##* results
#print(model)

##* Predict using the model we made.
'''
    if gui_params['task'] == 'Regression':
        results = results + 'predicted = predict(model, newdata = test_data, type="link")\n'
    elif gui_params['task'] == 'Classification':
        results = results + '## The gbm.predict gives probabilities rather than categorical outputs, so we modify to calculate confusion matrix by using caret library.\npredicted_prob = predict(model, newdata = test_data, type="response")\nnames_from_prob = names(predicted_prob[1,,1][])\npredicted=as.factor(apply(predicted_prob, 1, which.max))\nlevels(predicted) = names_from_prob\n'

    results = results + getBasicAnalyticGraph(output_col, gui_params['task'])
    return results

def getLocalRegression(gui_params):
    # getting column names
    input_cols, output_col, input_index_list, output_index = getInputOutputColumnNames(gui_params)
    
    results = "##* Local Regression\n"

    results = results + '''library(locfit)
model = locfit(formula = ''' + output_col + " ~ " + "lp(" + ", ".join(input_cols) + getExceptionalHyperParameters(gui_params) +")" +", data = train_data" + getHyperParametersandClosing(gui_params)
    
    results = results + getDefaultParametersDetails(gui_params) # describing default values of mandantory hyperparameters [nfolds, epochs, hidden]
    
    results = results + '''##* results
#print(model)

##* Predict using the model we made.
predicted = predict(model, newdata = test_data)
'''
    results = results + getBasicAnalyticGraph(output_col, gui_params['task'])
    return results

def getDeepLearning(gui_params):
    # getting column names
    input_cols, output_col, input_index_list, output_index = getInputOutputColumnNames(gui_params)
    
    results = "##* Deep Learning\n"

    

    results = results + '''library(h2o)
h2o.init()
train_frame = as.h2o(train_data)
test_frame = as.h2o(test_data)
'''
    results = results + "model = h2o.deeplearning(x = " + str(min(input_index_list)+1)  + ":" + str(max(input_index_list)+1) + ", y = " + str(output_index+1) + ", training_frame = train_frame" + getHyperParametersandClosing(gui_params)

    results = results + getDefaultParametersDetails(gui_params) # describing default values of mandantory hyperparameters [nfolds, epochs, hidden]
    
    results = results + '''##* results
print(model)

##* Predict using the model we made.
predicted = h2o.predict(model, test_frame)
'''
    if gui_params['task'] == 'Classification':
        results = results + 'predicted = predicted$predict'
    
    results = results + '''
##* Training Score (The metric can be replaced with "mae", "rmse", or "deviance")
plot(model, metric = "rmse")
'''
    results = results + getBasicAnalyticGraph(output_col, gui_params['task'])
    return results

##############################################################################################
##  Several Analysis Tools and Performance Evaluations (optional)
##############################################################################################

def getBasicAnalyticGraph(output_col, task):
    results = '''
## Comparing output data of the testing datasets(never learned) with the predicted output data using input data of the testing datasets.
vs = pd.DataFrame(np.c_[predicted, test_data[target]], columns=['Predicted', 'Actual'])
print(vs.head())
'''

    if task == 'Regression':
        results = results + '''
##* Plotting testing datasets vs. predicted datasets
vsplot, ax = plt.subplots(1, 1, figsize=(12,12))
ax.scatter(x = predicted, y = test_data[target], color='c', edgecolors=(0, 0, 0))
ax.plot([test_data[target].min(), test_data[target].max()], [test_data[target].min(), test_data[target].max()], 'k--', lw=4)
ax.set_xlabel('Predicted')
ax.set_ylabel('Actual')
plt.show()'''
     
    elif task == 'Classification':
        results = results + '''
##* Confusion Matrix and Statistics
library(caret)
cmatrix = confusionMatrix(data = vs[,1], reference = vs[,2], dnn = c("Prediction", "Actual"))
perf_acc_score = as.numeric(cmatrix$overall['Accuracy']) # save numeric score for comparing
print(cmatrix)'''

    return results   

def getAdditionalAnalyticResults(gui_params):
    results = ""
    for item in gui_params['analysis']:
        if item == 'leveragePlots': # available in MLR, not in SVM
            if gui_params['algorithm'] == 'MLR':
                #results = results + '\n##* Leverage Plots\nlibrary(car)\nleveragePlots(model)\n'
                results = ""

        elif item == 'qqPlot':	# available in MLR, not in SVM
            if gui_params['algorithm'] == 'MLR':
                #results = results + '\n##* Quantile-Quantile Plot\nlibrary(car)\nqqPlot(model, main="QQ Plot")\n'
                results = ""

        elif item == 'Distribution of Std. Residuals': # available in MLR, not in SVM
            if gui_params['algorithm'] == 'MLR':
                #results = results + '\n##* Distribution of Studentized Residuals\nlibrary(MASS)\nsresid <- studres(model)\nhist(sresid, freq=FALSE, main="Distribution of Studentized Residuals")\nxfit<-seq(min(sresid),max(sresid),length=40)\nyfit<-dnorm(xfit)\nlines(xfit, yfit)\n'
                results = ""

        elif item == 'Diagnostic Plots': # available in MLR, not in SVM
            if gui_params['algorithm'] == 'MLR':
                #results = results + "\n##* Diagnostic Plots\nlayout(matrix(c(1,2,3,4),2,2)) # optional 4 graphs/page\nplot(model)\nlayout(1)\n"
                results = ""

        elif item == 'OutlierTest': # available in MLR, not in SVM
            if gui_params['algorithm'] == 'MLR':
                #results = results + "\n##* Assessing Outliers\nprint('***Outlier Test ***')\nprint(outlierTest(model)) # Bonferonni p-value for most extreme obs\n"
                results = ""

        elif item == 'Variable Importance':
            results = results + "\n##* Importance of each predictor"
            if gui_params['algorithm'] == 'MLR':
                #results = results + "\nlibrary(caret)\nvarImp(model)\n"
                results = ""
            elif gui_params['algorithm'] == 'RF':
                results = results + "\nimportance(model)\n"
            elif gui_params['algorithm'] == 'BT':
                results = results + "\nsummary(model)\n"
            elif gui_params['algorithm'] == 'DL':
                results = results + "\nh2o.varimp(model)\nh2o.varimp_plot(model)\n"
            else:
                results = results + "\n# Variable importance may not supported in this algorithm.\n"

        elif item == 'AP Confusion Matrix':
            if gui_params['task'] == 'Classification':
                results = results + "\n##* Alluvial Plotting using Confusion Matrix\n"
                results = results + '''alluvial_plot_from_cm <- function(cm){
cmdf <- as.data.frame(cm[["table"]])
cmdf[["color"]] <- ifelse(cmdf[[1]] == cmdf[[2]], "blue", "red")
  
alluvial::alluvial(cmdf[,1:2]
                   , freq = cmdf$Freq
                   , col = cmdf[["color"]]
                   , border = "white"
                   , alpha = 0.5
                   , hide  = cmdf$Freq == 0)
}
alluvial_plot_from_cm(cmatrix)
'''
    return results

def getPerformanceEvaluationResults(gui_params):
    results = ""
    temp = ""
    if gui_params['task'] == 'Regression':
        for item in gui_params['perf_eval']:
            temp = '''# We support several metrics for regression by using sklearn.metrics functions
# metrics.explained_variance_score(y_true, y_pred)\tExplained variance regression score function
# metrics.mean_absolute_error(y_true, y_pred)\tMean absolute error regression loss
# metrics.mean_squared_error(y_true, y_pred[, …])\tMean squared error regression loss
# metrics.mean_squared_log_error(y_true, y_pred)\tMean squared logarithmic error regression loss
# metrics.median_absolute_error(y_true, y_pred)\tMedian absolute error regression loss
# metrics.r2_score(y_true, y_pred[, …])\tR^2 (coefficient of determination) regression score function.\n'''
            if item == 'mae': 
                results = results + "\n## Mean Absolute Error\nperf_mae = metrics.mean_absolute_error(vs['Actual'],vs['Predicted'])\nprint('*** Mean Squared Error = ', perf_mae)\n"
            elif item == 'mape':
                results = results + "\n## Mean Absolute Percentage Error\ndef mean_absolute_percentage_error(y_true, y_pred):\n    y_true, y_pred = np.array(y_true), np.array(y_pred)\n    return np.mean(np.abs((y_true - y_pred) / y_true)) * 100\nperf_mape = mean_absolute_percentage_error(vs['Actual'], vs['Predicted'])\nprint('*** Mean Absolute Percentage Error = ', perf_mape)\n"
            elif item == 'rmse': 
                results = results + "\n## Root Mean Squared Error\nperf_rmse = np.sqrt(metrics.mean_squared_error(vs['Actual'], vs['Predicted']))\nprint('*** Root Mean Squared Error = ', perf_rmse)\n"
            elif item == 'rmsle': 
                results = results + "\n## Root Mean Squared Log Error\nperf_rmsle = np.sqrt(metrics.mean_squared_log_error(vs['Actual'], vs['Predicted']))\nprint('*** Root Mean Squared Log Error = ', perf_rmsle)\n"
            elif item == 'r2': 
                results = results + "\n## Coefficient of Determination (R Squared)\nperf_r2 = metrics.r2_score(vs['Actual'], vs['Predicted'])\nprint('*** Coefficient of Determination (R Squared) = ', perf_r2)\n"

    elif gui_params['task'] == 'Classification':
        for item in gui_params['perf_eval']:
            if item == 'accuracy':
                results = results + '\n## Categorization Accuracy\nsprintf("*** Categorization Accuracy = %f",perf_acc_score)\n'
            elif item == 'meanf1':
                temp_function = '''
F1Score <- function (fact, pred) {
    "%ni%" <- Negate("%in%")
    fact <- strsplit(fact, " ")
    fact <- fact[nzchar(fact)][[1]]
    
    pred <- strsplit(pred, " ")
    pred <- pred[nzchar(pred)][[1]]
    
    TP = sum(pred %in% fact)
    
    if(TP == 0) {
        return(0)
    }
    
    precision <- TP/length(pred)
    recall <- TP/length(fact)
    
    2 * precision * recall / (precision + recall)
}

applyF1Score <- function (df) {
    apply(df, 1, function (x) F1Score(x["Actual"], x["Prediction"]))
}
'''
                results = results + '\n## Mean F-1 Score\n' + temp_function + '\nperf_mean_f1_score = mean(applyF1Score(vs))\nsprintf("*** Mean F-1 Score = %f",perf_mean_f1_score)\n'
                
    return temp + results

def getDefaultParametersDetails(gui_params):
    defaultParameters = ""
    seeAllParameters = ""
    referenceAddress = ""
    description = "#- [OPTION_NAME = (default value)]"
    indent = "\n"
    
    if gui_params['algorithm'] == 'MLR':
        defaultParameters ='''
#- LinearRegression(fit_intercept=True, normalize=False, copy_X=True, n_jobs=1)
#- fit_intercept // boolean, optional, default True. whether to calculate the intercept for this model. If set to False, no intercept will be used in calculations (e.g. data is expected to be already centered).
#- normalize // boolean, optional, default False. This parameter is ignored when fit_intercept is set to False. If True, the regressors X will be normalized before regression by subtracting the mean and dividing by the l2-norm. If you wish to standardize, please use sklearn.preprocessing.StandardScaler before calling fit on an estimator with normalize=False.
#- copy_X // boolean, optional, default True. If True, X will be copied; else, it may be overwritten.
#- n_jobs // int, optional, default 1. The number of jobs to use for the computation. If -1 all CPUs are used. This will only provide speedup for n_targets > 1 and sufficient large problems.
'''
        #seeAllParameters = ""
        referenceAddress = "#- http://scikit-learn.org/stable/modules/generated/sklearn.linear_model.LinearRegression.html\n"

    elif gui_params['algorithm'] == 'SVM':
        defaultParameters ='''
#- formula // A symbolic description of the model to be fit.
#- data // An optional data frame containing the variables in the model.
#- kernel = "radial" // The kernel used in training and predicting. It is able to change depending on the kernel type such as 'linear', 'polynomial', 'radial', and 'sigmoid'.
#- cross = 0 // A k-fold cross validation on the training data to assess the quality of the model regarding the accuracy rate for classification and the MSE for regression.
'''
        #seeAllParameters = ""
        referenceAddress = "#- https://cran.r-project.org/web/packages/e1071/e1071.pdf\n"
    elif gui_params['algorithm'] == 'RF':
        defaultParameters ='''
#- formula // A data frame or a matrix of predictors, or a formula describing the model to be fitted.
#- data // An optional data frame containing the variables in the model.
#- ntree = 500 // Number of trees to grow. This should not be set to too small a number, to ensure that every input row gets predicted at least a few times.
'''
        #seeAllParameters = ""
        referenceAddress = "#- https://cran.r-project.org/web/packages/randomForest/randomForest.pdf\n"
    elif gui_params['algorithm'] == 'BT':
        defaultParameters ='''
#- formula // A symbolic description of the model to be fit. It may include an offset term (e.g., y ~ offset(n) + x)
#- data // Data Frame.
#- n.trees = 100 // The total number of trees to fit. This is equivalent to the number of iterations and the number of basis functions in the additive expansion.
#- cv.folds // Number of cross-validation folds to perform. 'cv.error' shows an estimate of generalization error.
'''
        #seeAllParameters =""
        referenceAddress = "#- https://cran.r-project.org/web/packages/gbm/gbm.pdf\n"
    elif gui_params['algorithm'] == 'LR':
        defaultParameters ='''
#- formula // Model Formula; e.g. y~lp(x) for a regression model; ~lp(x) for a density estimation model. Use of lp() on the RHS is recommended, especially when non-default smoothing parameters are used.
#- data // Data Frame.
#- lp() // local ploynomial model term for Locfit models.
#- lp(..., nn, scale)
#- ... // Predictor variables for the local regression model.
#- nn = 0.7 // Nearest neighbor components of the smoothing parameter. If too small, you may get a warning message.
#- scale = FALSE // A scale to apply to each variable. This is especially important for multivariate fitting, where variables may be measured in non-comparable units. It is also used to specify the frequency for ang terms. If scale=F (the default) no scaling is performed. If scale=T, marginal standard deviations are used.
'''
        #seeAllParameters =""
        referenceAddress = "#- https://cran.r-project.org/web/packages/locfit/locfit.pdf\n"
    elif gui_params['algorithm'] == 'DL':
        # mandantories - nfolds, epochs, hidden
        defaultParameters = '''
#- x // (Optional) A vector containing the names or indices of the predictor variables to use in building the model. If x is missing, then all columns except y are used.
#- y // The name or column index of the response variable in the data. The response must be either a numeric or a categorical/factor variable. If the response is numeric, then a regression model will be trained, otherwise it will train a classification model.
#- training_frame // Id of the training data frame.
#- nfolds = 0 // Number of folds for K-fold cross-validation (0 to disable or >= 2).
#- epochs = 10 // How many times the dataset should be iterated (streamed), can be fractional.
#- hidden = c(200,200) // Hidden layer sizes (e.g. [200, 200]).
'''
        seeAllParameters = '''#- [Parameters Details] h2o.deeplearning(x, y, training_frame, model_id = NULL,validation_frame = NULL, nfolds = 0,keep_cross_validation_predictions = FALSE,keep_cross_validation_fold_assignment = FALSE, fold_assignment = c("AUTO","Random", "Modulo", "Stratified"), fold_column = NULL,ignore_const_cols = TRUE, score_each_iteration = FALSE,weights_column = NULL, offset_column = NULL, balance_classes = FALSE,class_sampling_factors = NULL, max_after_balance_size = 5,max_hit_ratio_k = 0, checkpoint = NULL, pretrained_autoencoder = NULL,overwrite_with_best_model = TRUE, use_all_factor_levels = TRUE,standardize = TRUE, activation = c("Tanh", "TanhWithDropout", "Rectifier","RectifierWithDropout", "Maxout", "MaxoutWithDropout"), hidden = c(200,200), epochs = 10, train_samples_per_iteration = -2,target_ratio_comm_to_comp = 0.05, seed = -1, adaptive_rate = TRUE,h2o.deeplearning 59rho = 0.99, epsilon = 1e-08, rate = 0.005, rate_annealing = 1e-06,rate_decay = 1, momentum_start = 0, momentum_ramp = 1e+06,momentum_stable = 0, nesterov_accelerated_gradient = TRUE,input_dropout_ratio = 0, hidden_dropout_ratios = NULL, l1 = 0, l2 = 0,max_w2 = 3.4028235e+38, initial_weight_distribution = c("UniformAdaptive","Uniform", "Normal"), initial_weight_scale = 1, initial_weights = NULL,initial_biases = NULL, loss = c("Automatic", "CrossEntropy", "Quadratic","Huber", "Absolute", "Quantile"), distribution = c("AUTO", "bernoulli","multinomial", "gaussian", "poisson", "gamma", "tweedie", "laplace","quantile", "huber"), quantile_alpha = 0.5, tweedie_power = 1.5,huber_alpha = 0.9, score_interval = 5, score_training_samples = 10000,score_validation_samples = 0, score_duty_cycle = 0.1,classification_stop = 0, regression_stop = 1e-06, stopping_rounds = 5,stopping_metric = c("AUTO", "deviance", "logloss", "MSE", "RMSE", "MAE","RMSLE", "AUC", "lift_top_group", "misclassification","mean_per_class_error"), stopping_tolerance = 0, max_runtime_secs = 0,score_validation_sampling = c("Uniform", "Stratified"),diagnostics = TRUE, fast_mode = TRUE, force_load_balance = TRUE,variable_importances = TRUE, replicate_training_data = TRUE,single_node_mode = FALSE, shuffle_training_data = FALSE,missing_values_handling = c("MeanImputation", "Skip"), quiet_mode = FALSE,autoencoder = FALSE, sparse = FALSE, col_major = FALSE,average_activation = 0, sparsity_beta = 0,max_categorical_features = 2147483647, reproducible = FALSE,export_weights_and_biases = FALSE, mini_batch_size = 1,categorical_encoding = c("AUTO", "Enum", "OneHotInternal", "OneHotExplicit","Binary", "Eigen", "LabelEncoder", "SortByResponse", "EnumLimited"),elastic_averaging = FALSE, elastic_averaging_moving_rate = 0.9,elastic_averaging_regularization = 0.001, verbose = FALSE)\n'''
        referenceAddress = "#- https://cran.r-project.org/web/packages/h2o/h2o.pdf\n"
            
    return  description + defaultParameters + "#- You can find arguments details on R cran repository at\n" + referenceAddress + indent
