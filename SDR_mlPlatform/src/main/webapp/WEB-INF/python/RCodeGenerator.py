'''
# GUI based automatic R code generator for Machine Learning

implemented by Jeongcheol Lee
5% ver 0.1 @ 2018.7.18 -
10% ver 0.11 @ 2018.7.19 - insert seperator '##*' to distinguish notes in an ipynb
30% ver 0.15 @ 2018. 7. 24 - import relations between objects
50% ver 0.2 @ 2018. 7. 26 - basic options and references done for regression (MLR, SVM, RF, BT, LR, DL)
70% ver 0.25 @ 2018. 8. 2 - gui_params['number_of_rows'] deleted -> num of rows for a ML dataset view will be calculated under the background java process.
70% ver 0.25 @ 2018. 8. 2 - analysis tool for classification - confusion matrix (yet no plot for R, sns for python), alluvial plot by using confusion matrix, categorization accuracy, and mean f-1 score for predict vs validation set.
80% ver 0.3 @ 2018. 8. 3 - classification algorithms included (SVM, RF, BT, DL)

so we have the rest,
[more graph...]
[jpg to matrix array] - need to discuss // 1. file list json, 2. direct read image, ...
'''

##############################################################################################

def from_gui_to_code(gui_params):
    prev = ""
    body = ""
    post = ""
    if gui_params:	# if it exists
        prev = getDataLoading(gui_params)
        body = getAlgorithmBody(gui_params)
        post = getEvaluation(gui_params)
    return prev+"\n"+body+"\n"+post

##############################################################################################

def getDataLoading(gui_params):
    data_loading = '''##* Data Loading
all_data = read.csv("'''+gui_params['ml_file_path']+gui_params['ml_file_name']+'''", sep=",", header=TRUE)

## Discover the head of your data
head(all_data)

'''
    pre_processing_imputation = '''##* Pre-processing - 1. Inpute Missing values
## There are many options in order to deal with a missing value such as:
## - A constant value that has meaning within the domain, such as 0, distinct from all other values.
## - A value from another randomly selected record.
## - A mean, median or mode value for the column.
## - A value estimated by another predictive model.
## We are going to replace a missing value to 0. The following is the Simple R function.

na.zero <- function (x) {
    x[is.na(x)] <- 0
    return(x)
}

## Filling 0 for missing values
all_data <- na.zero(all_data)

'''
    pre_processing_vectorization = '''##* Pre-processing - 2. Vectorization
''' + doVectorization(gui_params)

    train_test_split = '''##* Train and Test Dataset Split
'''
    if gui_params['testing_frame_extract_method'] == 'random':
        train_test_split = train_test_split + '''set.seed(123)
all_data = all_data[sample(nrow(all_data)), ]\t# data shuffling
'''
    elif gui_params['testing_frame_extract_method'] == 'basic':
        pass

    train_test_split = train_test_split + "training_frame_rate = " + str(1-gui_params['testing_frame_rate']) + "\nsplit_num = floor(nrow(all_data)*training_frame_rate)\nprint(split_num)\n" + "train_data = all_data[1:split_num, ]\ntest_data = all_data[(split_num+1):nrow(all_data), ]\n"

    return data_loading +pre_processing_imputation +pre_processing_vectorization + "\n"+ train_test_split

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
    results = ""
    for column_index in gui_params['datatype_of_columns']:
        if gui_params['datatype_of_columns'][column_index] == 'Numeric':
            pass
        elif gui_params['datatype_of_columns'][column_index] == 'String' or 'Boolean' or 'Date':
            results = results + 'all_data["'+gui_params['whole_columns_index_and_name'][column_index]+'"] <- as.factor(all_data$' + gui_params['whole_columns_index_and_name'][column_index] + ')\n'
            results = results + '\n## Plot types\nbarplot(table(all_data$'+ gui_params['whole_columns_index_and_name'][column_index] + '), col = rainbow(nlevels(all_data$' + gui_params['whole_columns_index_and_name'][column_index] + '), 0.5), main = "n Types of ' + gui_params['whole_columns_index_and_name'][column_index] + '", las = 2)\n'

    if results == "":
    	results = "## Numeric data only. There is nothing to be vectorized.\n"
    return results

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
                    annotate_list.append("k-fold cross-validation")
                    outer_options_list.append("library(DAAG)\ncv.lm(data = train_data, form.lm = model, m = "+str(gui_params['hparams'][hparam])+", printit = FALSE)")
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

##############################################################################################
##  Algorithms
##############################################################################################


def getMultipleLinearRegression(gui_params):
    # getting column names
    input_cols, output_col, input_index_list, output_index = getInputOutputColumnNames(gui_params)

    results = "##* Multiple Linear Regression\nmodel = lm(formula = " + output_col + " ~ " + " + ".join(input_cols) + ", data = train_data" + getHyperParametersandClosing(gui_params)

    results = results + getDefaultParametersDetails(gui_params) # describing default values of mandantory hyperparameters

    results = results + '''##* results
summary(model)

##* Predict using the model we made.
predicted = predict(model, newdata = test_data)
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
summary(model)

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
h2o.init(ip="172.16.10.192",port=54321)
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
vs <- cbind(as.data.frame(predicted), as.data.frame(test_data$'''+output_col+'''))
names(vs) <- c("Prediction", "Actual")
head(vs)
'''

    if task == 'Regression':
        results = results + '''
##* Plotting testing datasets vs. predicted datasets
plot(vs)
abline(a=0,b=1)'''

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
                results = results + '\n##* Leverage Plots\nlibrary(car)\nleveragePlots(model)\n'

        elif item == 'qqPlot':	# available in MLR, not in SVM
            if gui_params['algorithm'] == 'MLR':
                results = results + '\n##* Quantile-Quantile Plot\nlibrary(car)\nqqPlot(model, main="QQ Plot")\n'

        elif item == 'Distribution of Std. Residuals': # available in MLR, not in SVM
            if gui_params['algorithm'] == 'MLR':
                results = results + '\n##* Distribution of Studentized Residuals\nlibrary(MASS)\nsresid <- studres(model)\nhist(sresid, freq=FALSE, main="Distribution of Studentized Residuals")\nxfit<-seq(min(sresid),max(sresid),length=40)\nyfit<-dnorm(xfit)\nlines(xfit, yfit)\n'

        elif item == 'Diagnostic Plots': # available in MLR, not in SVM
            if gui_params['algorithm'] == 'MLR':
                results = results + "\n##* Diagnostic Plots\nlayout(matrix(c(1,2,3,4),2,2)) # optional 4 graphs/page\nplot(model)\nlayout(1)\n"

        elif item == 'OutlierTest': # available in MLR, not in SVM
            if gui_params['algorithm'] == 'MLR':
                results = results + "\n##* Assessing Outliers\nlibrary(car)\nprint('***Outlier Test ***')\nprint(outlierTest(model)) # Bonferonni p-value for most extreme obs\n"

        elif item == 'Variable Importance':
            results = results + "\n##* Importance of each predictor"
            if gui_params['algorithm'] == 'MLR':
                results = results + "\nlibrary(caret)\nvarImp(model)\n"
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
            if item == 'mae':
                results = results + '\n## Mean Absolute Error\nlibrary(Metrics)\nperf_mae = mae(vs[,2],vs[,1])  # mae(actual, predicted)\nsprintf("*** Mean Squared Error = %f", perf_mae)\n'
            elif item == 'mape':
                results = results + '\n## Mean Absolute Percentage Error\nlibrary(Metrics)\nperf_mape = mape(vs[,2],vs[,1])  # mape(actual, predicted)\nsprintf("*** Mean Absolute Percentage Error = %f", perf_mape)\n'
            elif item == 'rmse':
                results = results + '\n## Root Mean Squared Error\nlibrary(Metrics)\nperf_rmse = rmse(vs[,2],vs[,1])  # rmse(actual, predicted)\nsprintf("*** Root Mean Squared Error = %f", perf_rmse)\n'
            elif item == 'rmsle':
                results = results + '\n## Root Mean Squared Log Error\nlibrary(Metrics)\nperf_rmsle = rmsle(vs[,2],vs[,1])  # rmsle(actual, predicted)\nsprintf("*** Root Mean Squared Log Error = %f", perf_rmsle)\n'
            elif item == 'r2':
                results = results + '\n## Coefficient of Determination (R Squared)'
                temp = '''
# Define the normal coefficient of determination (R Squared)

na.nr2 <- function(actual, preds){
    rss <- sum((preds - actual)^2)
    tss <- sum((actual - mean(actual))^2)
    rsq <- 1- rss/tss

    return(rsq)
}
'''
                if gui_params['algorithm'] == 'MLR':
                    results = results + '\nlibrary(rsq)\nperf_r2 = rsq(model)  # use rsq.partial(model) when partial R-Squared for Generalized Linear Models\n'
                elif gui_params['algorithm'] == 'DL':
                    results = results + '\nperf_r2 = h2o.r2(model, xval=FALSE)\t#using xval=TRUE when retrieving the cross-validation R2\n'
                else:	# in the cases of SVM, RF, BT, LR
            	    results = results + temp + '\nperf_r2 = na.nr2(vs[,2],vs[,1])\n'
                results = results + 'sprintf("*** Coefficient of Determination (R Squared) = %f", perf_r2)\n'

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

    return results

def getDefaultParametersDetails(gui_params):
    defaultParameters = ""
    seeAllParameters = ""
    referenceAddress = ""
    description = "#- [OPTION_NAME = (default value)]"
    indent = "\n"

    if gui_params['algorithm'] == 'MLR':
        defaultParameters ='''
#- formula // A symbolic description of the model to be fit.
#- data // Data frame.
'''
        #seeAllParameters = ""
        referenceAddress = "#- https://tutorials.iq.harvard.edu/R/Rstatistics/Rstatistics.html\n"

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
