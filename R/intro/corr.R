corr <- function(directory, threshold = 0)
{
    ## 'directory' is a character vector of length 1 indicating
    ## the location of the CSV files
    
    ## 'threshold' is a numeric vector of length 1 indicating the
    ## number of completely observed observations (on all
    ## variables) required to compute the correlation between
    ## nitrate and sulfate; the default is 0
    
    ## Return a numeric vector of correlations
    
    dir = paste('~/documents/code/r/data/', directory, sep='')
    res = c()
    for(fh in list.files(dir, full.names=T))
    {
        data = read.csv(fh, header=T)
        # cmplt: the number of complete tuples
        cmplt = sum(complete.cases(data))
        if(cmplt < threshold)
            next
        else
            res = c(res, cor(data$sulfate, data$nitrate, 
                             use='pairwise.complete.obs'))
    }
    
    return(res)
}