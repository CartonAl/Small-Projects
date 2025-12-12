package main  

import (
	"fmt"
	"strings"
)

func countWords(s string) map[string]int {
	words := strings.Fields(s)
	wordCount := make(map[string]int)

	for _, word := range words {
		word = strings.ToLower(word)
		wordCount[word]++
	}

	return wordCount

}

// Do not change the code in the main function  
func main() {
	s := "go is fun and go is fast"
	fmt.Println(countWords(s))
	t := "this is a test this is only a test"
	fmt.Println(countWords(t))
}