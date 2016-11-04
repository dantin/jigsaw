package main

import (
    "strings"
    "golang.org/x/tour/wc"
)

func WordCount(s string) map[string]int {
    count := make(map[string]int)
    for _, token := range strings.Fields(s) {
        count[token]++
    }
    
    return count
}

func main() {
    wc.Test(WordCount)
}
