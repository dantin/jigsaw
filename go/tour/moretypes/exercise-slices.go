package main

import "golang.org/x/tour/pic"

func Pic(dx, dy int) [][]uint8 {
    // Allocate two-dimension array.
    a := make([][]uint8, dy)
    for i := 0; i < dy; i++ {
        a[i] = make([]uint8, dx)
    }

    // Do something
    for y := range a {
        for x := range a[y] {
            a[y][x] = uint8(x^y)
        }
    }
    return a
}

func main() {
    pic.Show(Pic)
}