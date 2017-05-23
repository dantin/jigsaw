package main

import "fmt"

func coin_change(money []int, total int) int {
	dp := make([]int, total + 1)

    dp[0] = 1
    for i := 0; i < len(money); i++ {
        for j := money[i]; j <= total; j++ {
            dp[j] += dp[j - money[i]]
        }
    }

	return dp[total]
}

func main() {
	var total, size int

	fmt.Scan(&total, &size)
	coins := make([]int, size)
	for i := 0; i < size; i++ {
		fmt.Scan(&coins[i])
	}

	fmt.Println(coin_change(coins, total))
}
