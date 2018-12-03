#h2o.R package required
#.libPaths("d:/oqmd/library")
.libPaths()
library(h2o)
library(df2json)

args<-commandArgs(TRUE)

scriptRootPath<-args[1]
input_csv_path<-args[2]
#batteryornot<-args[3]

csv<-paste(input_csv_path,"/output-with-cm.csv",sep="")

#if(batteryornot) {
csv2<-paste(input_csv_path,"/output-element-only.csv",sep="")
#}
test_data = 0
test_data2= 0 
test_data = read.csv(csv, sep=",", header=TRUE)
test_data2 = read.csv(csv2, sep=",", header=TRUE)

na.zero <- function (x) {
    x[is.na(x)] <- 0
    return(x)
}

#zero padding
test_data <- na.zero(test_data)
#if(batteryornot) {
test_data2 <- na.zero(test_data2)
#}
test_data["spacegroup_crystal_system"] <- as.factor(test_data$spacegroup_crystal_system)
test_data["spacegroup_hall"] <- as.factor(test_data$spacegroup_hall)
test_data["spacegroup_point_group"] <- as.factor(test_data$spacegroup_point_group)
test_data["spacegroup_symbol"] <- as.factor(test_data$spacegroup_symbol)
test_data["spacegroup_number"] <- as.factor(test_data$spacegroup_number)

test_data2["spacegroup_crystal_system"] <- as.factor(test_data2$spacegroup_crystal_system)
test_data2["spacegroup_hall"] <- as.factor(test_data2$spacegroup_hall)
test_data2["spacegroup_point_group"] <- as.factor(test_data2$spacegroup_point_group)
test_data2["spacegroup_symbol"] <- as.factor(test_data2$spacegroup_symbol)
test_data2["spacegroup_number"] <- as.factor(test_data2$spacegroup_number)
#loading h2o deep learning module
h2o.init()
#h2o.connect(ip="localhost", port=54321)
testing_frame=as.h2o(test_data)
#if(batteryornot) {
testing_frame2=as.h2o(test_data2)
#}

#loading pre-learned model
formenergy_model <- h2o.loadModel(path=paste(scriptRootPath,"/models/DeepLearning_model_R_FormE_0.09_svd(512_512_256_128)",sep=""))
finalenergy_model <- h2o.loadModel(path=paste(scriptRootPath,"/models/DeepLearning_model_R_FinalE_0.11_element_only(512_512_256_128)",sep=""))
#eabovehull_model <- h2o.loadModel(path=paste(scriptRootPath,"/models/DeepLearning_model_R_EaboveHull_0.05(512_512_256_128)",sep=""))
#formenergy_model <- h2o.getModel(model_id="DeepLearning_model_R_1504173386075_7")
#eabovehull_model <- h2o.getModel(model_id="DeepLearning_model_R_1504173386075_9")

predicted_formation_energy_per_atom = as.data.frame(h2o.predict(formenergy_model, testing_frame))
predicted_final_energy_per_atom = as.data.frame(h2o.predict(finalenergy_model, testing_frame))
#if(batteryornot) {
predicted_final_energy_per_atom_from_subelement = as.data.frame(h2o.predict(finalenergy_model, testing_frame2))
#}
#predicted_eabovehull = as.data.frame(h2o.predict(eabovehull_model, testing_frame))

names(predicted_formation_energy_per_atom)[1] <- c("formation_energy_per_atom")
names(predicted_final_energy_per_atom)[1] <- c("final_energy_per_atom")
#if(batteryornot) {
names(predicted_final_energy_per_atom_from_subelement)[1] <- c("sub_final_energy_per_atom")
#}
#names(predicted_eabovehull)[1] <- ("e_above_hull")

#if(batteryornot) {
result = cbind(predicted_formation_energy_per_atom, predicted_final_energy_per_atom, predicted_final_energy_per_atom_from_subelement)
#} else {
#result = cbind(predicted_formation_energy_per_atom, predicted_final_energy_per_atom, predicted_eabovehull)
#}
output = df2json(result)
write(output, paste(input_csv_path,"/preparing_output.json",sep=""))
