# About
This repository aims to collect and clean a data set for later analysis. The R script "*run_analysis.R*" details the process. Source it in the RStudio or run R command in the terminal if you want to test the script. The "*CodeBook.md*" describes the data and the transformations on them. 

The specific tasks are following:

### Merges the training and the test sets to create one data set
Consider the training sets, the training data "*X_train.txt*", the subjects "*subject_train.txt*" and the labels "*y_train.txt*" were read into R respectively, and then merged using ```cbind()``` to form the training set. The test sets were formed in the same way.

The names of 561 features are ready in "*features.txt*". The names were read into R and assigned to the names of columns.

### Extracts only the measurements on the mean and standard deviation for each measurement
According to the "*features_info.txt*" which is not included in the repo (can be downloaded from [here](https://d396qusza40orc.cloudfront.net/getdata%2Fprojectfiles%2FUCI%20HAR%20Dataset.zip)):

> The set of variables that were estimated from these signals are:  
> 
> mean(): Mean value  
> std(): Standard deviation

the required measurements, of which names contain the above keywords can be extracted by ```grep()``` with a pattern containing "mean()" and "std()".

### Uses descriptive activity names to name the activities in the data set
The activities in the data set are represented by number 1 to 6. The decriptive names are stored in "*activity_labels.txt*". The task was accomplished by transforming the column from numeric to factor then assigning the names in "*activity_labels.txt*" to the levels of factors.


### Appropriately labels the data set with descriptive variable names
The task was accomplished in task 1.

### From the data set in step 4, creates a second, independent tidy data set with the average of each variable for each activity and each subject
The ```reshape2``` package was used in this task. First, the data table was melted down with id "label" and "subject"; subsequently, the melted data table was reconstructed with aggregation (i.e. mean)  by ```cast()``` function. The tidy data was written to "*my_tidy_data.txt*".