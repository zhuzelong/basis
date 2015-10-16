## Put comments here that give an overall description of what your
## functions do

## Creates a special matrix object that can cache its inverse.
makeCacheMatrix <- function(x = matrix())
{
    inv = NULL
    
    get = function()
    {
        x
    }
    
    set.inverse = function(inv.matrix)
    {
        inv <<- inv.matrix
    }
    
    get.inverse = function()
    {
        inv
    }
    
    list(get=get, set.inverse=set.inverse, get.inverse=get.inverse)
}


## Computes the inverse of the special matrix returned by
## makeCacheMatrix. If the inverse exists, retrive the inverse.
cacheSolve <- function(x, ...)
{
    inv = x$get.inverse()
    if(!is.null(inv))
    {
        message('Getting cache matrix')
        return(inv)
    }
    mat = x$get()
    mat = solve(mat)
    x$set.inverse(mat)
    mat
}