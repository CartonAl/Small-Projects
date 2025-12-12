package main  

import "fmt"  

func swap(a *int, b *int) {  
    //Your code goes here  
	temp := *a
    *a = *b
    *b = temp
}  

// Do not change the code in the main function  
func main() {  
    x := 10  
    y := 20  

    swap(&x, &y)  
    fmt.Println(x, y)  
} 