complete <- function(directory, id = 1:332)
{
    ## 'directory' is a character vector of length 1 indicating
    ## the location of the CSV files
    
    ## 'id' is an integer vector indicating the monitor ID numbers
    ## to be used
    
    ## Return a data frame of the form:
    ## id nobs
    ## 1  117
    ## 2  1041
    ## ...
    ## where 'id' is the monitor ID number and 'nobs' is the
    ## number of complete cases
    
    counts = c()
    for(i in id)
    {
        i = sprintf('%03d', i)
        data = read.csv(paste('~/documents/code/r/data/', directory,
                                '/', i, '.csv', sep=''))
        cmplt = sum(complete.cases(data))
        counts = c(counts, cmplt)
    }
    
    data.frame(id=id, nobs=counts)
}