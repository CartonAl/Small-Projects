package main  

import "fmt"  

//Your code goes here  
type Rectangle struct {
    Width, Height int
}

func (r Rectangle) Area() int {
	return r.Width * r.Height
}

// Do not change the code in the main function  
func main() {  
    rect := Rectangle{Width: 10, Height: 5}   
    fmt.Println("Area:", rect.Area())  
    
}