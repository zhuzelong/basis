# R script for the course project of "Getting and cleaning data" on coursera.
# Author: Zhu Zelong
# Objective: Given the separate sensor data, prepare the tidy data sets.

# 1. > Merge the training and the test sets to create one data set.
setwd('~/Documents/code/courses/R/')
# 1.1 Read training sets
# Read X_train
xtrain = read.table('./data/UCI HAR Dataset/train/X_train.txt', header=F)
# Read subject_train
sbjtrain = read.table('./data/UCI HAR Dataset/train/subject_train.txt',
                      header=F)
# Read training labels
ytrain = read.table('./data/UCI HAR Dataset/train/y_train.txt', header=F)

# Read features' names
features = read.table('./data/UCI HAR Dataset/features.txt', header=F,
                      stringsAsFactors=F)
features = features[, 2]
# Read Inertial data
# body.acc.x.train = read.table('./data/UCI HAR Dataset/train/Inertial Signals/body_acc_x_train.txt',
                              # header=F)
# body.acc.y.train = read.table('./data/UCI HAR Dataset/train/Inertial Signals/body_acc_y_train.txt',
                              # header=F)
# body.acc.z.train = read.table('./data/UCI HAR Dataset/train/Inertial Signals/body_acc_z_train.txt',
                              # header=F)
# body.gyro.x.train = read.table('./data/UCI HAR Dataset/train/Inertial Signals/body_gyro_x_train.txt',
                              # header=F)
# body.gyro.y.train = read.table('./data/UCI HAR Dataset/train/Inertial Signals/body_gyro_y_train.txt',
                              # header=F)
# body.gyro.z.train = read.table('./data/UCI HAR Dataset/train/Inertial Signals/body_gyro_z_train.txt',
                              # header=F)
# total.acc.x.train = read.table('./data/UCI HAR Dataset/train/Inertial Signals/total_acc_x_train.txt',
                              # header=F)
# total.acc.y.train = read.table('./data/UCI HAR Dataset/train/Inertial Signals/total_acc_y_train.txt',
                              # header=F)
# total.acc.z.train = read.table('./data/UCI HAR Dataset/train/Inertial Signals/total_acc_z_train.txt',
                              # header=F)

# Merge training sets, based on the order described in "README.txt" in dataset.
names(xtrain) = features
names(ytrain) = 'label'
names(sbjtrain) = 'subject'
train = cbind(xtrain, ytrain, sbjtrain)

# 1.2 Read test sets
# Read X_test
xtest = read.table('./data/UCI HAR Dataset/test/X_test.txt', header=F)
# Read subject_test
sbjtest = read.table('./data/UCI HAR Dataset/test/subject_test.txt',
                      header=F)
# Read test labels
ytest = read.table('./data/UCI HAR Dataset/test/y_test.txt', header=F)
# Read Inertial data
# body.acc.x.test = read.table('./data/UCI HAR Dataset/test/Inertial Signals/body_acc_x_test.txt',
                              # header=F)
# body.acc.y.test = read.table('./data/UCI HAR Dataset/test/Inertial Signals/body_acc_y_test.txt',
                              # header=F)
# body.acc.z.test = read.table('./data/UCI HAR Dataset/test/Inertial Signals/body_acc_z_test.txt',
                              # header=F)
# body.gyro.x.test = read.table('./data/UCI HAR Dataset/test/Inertial Signals/body_gyro_x_test.txt',
                              # header=F)
# body.gyro.y.test = read.table('./data/UCI HAR Dataset/test/Inertial Signals/body_gyro_y_test.txt',
                              # header=F)
# body.gyro.z.test = read.table('./data/UCI HAR Dataset/test/Inertial Signals/body_gyro_z_test.txt',
                              # header=F)
# total.acc.x.test = read.table('./data/UCI HAR Dataset/test/Inertial Signals/total_acc_x_test.txt',
                              # header=F)
# total.acc.y.test = read.table('./data/UCI HAR Dataset/test/Inertial Signals/total_acc_y_test.txt',
                              # header=F)
# total.acc.z.test = read.table('./data/UCI HAR Dataset/test/Inertial Signals/total_acc_z_test.txt',
                              # header=F)

# Merge test sets, based on the order described in "README.txt" in dataset.
names(xtest) = features
names(ytest) = 'label'
names(sbjtest) = 'subject'
test = cbind(xtest, ytest, sbjtest)

# 1.3 Merge training set and test set
all = rbind(train, test)


# 2. > Extract only the measurements on the mean and standard deviation
#      for each measurement.
# Extract features with "mean()" or "std()", retain labels and subjects
pattern = 'mean\\(\\)|std\\(\\)'
sub.all = all[, c(grep(pattern, names(all), value=T), 'label', 'subject')]


# 3. > Uses descriptive activity names to name the activities in the data set.
labels = read.table('./data/UCI HAR Dataset/activity_labels.txt', header=F,
                    col.names=c('id', 'name'), stringsAsFactors=F)
sub.all$label = as.factor(sub.all$label)
levels(sub.all$label) = labels$name


# 4. > Appropriately labels the data set with descriptive variable names.
# Done at the end of step 1.
names(sub.all)

# 5. > From the data set in step 4, creates a second, independent tidy data set
#      with the average of each variable for each activity and each subject.

# Use 'reshape2' package to accomplish the task
if(!require('reshape2'))
    print('Need to install reshape2 package')

# Melt the data frame
md = melt(sub.all, id=c('label', 'subject'))

# Aggregate the data frame
data = dcast(md, formula=subject + label ~ variable, mean) 


# Print out the tidy data
write.table(data, file='./data/my_tidy_data.txt', row.name=F)
