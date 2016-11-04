package main

import (
    "fmt"
)

const DELTA = 0.00000001

func abs(x float64) float64 {
    if x < 0 {
        return -x
    } else {
        return x
    }
    // return x < 0 ? -x : x;
}

func Sqrt(x float64) float64 {
    z := float64(1)

    t := z + 1
    for ; abs(t - z) > DELTA ; {
        t = z
        z = z - (z * z - x) / float64(2 * z)
    }

    return z
}

func main() {
    fmt.Println(Sqrt(2))
}