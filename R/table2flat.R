table2flat = function(mytable)
{
    # Convert table back to flat file (data frame)
    df = as.data.frame(mytable)
    rows = dim(df)[1]
    cols = dim(df)[2]
    x = NULL
    
    for(i in 1:rows)
    {
        for(j in 1:cols)
        {
            row = df[i, c(1: (cols-1))]
            x = rbind(x, row)
        }
    }
    
    row.names(x) = c(1: dim(x)[1])
    return(x)
}