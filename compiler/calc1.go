package main

import "fmt"
import "unicode"

type token_type int

const (
	Integer token_type = iota
	Plus
	Eof
)

type token struct {
	typ   token_type
	value interface{}
}

func (t token) String() string {
	var typ string
	switch t.typ {
	case Integer:
		typ = "INTEGER"
	case Plus:
		typ = "PLUS"
	case Eof:
		typ = "EOF"
	}
	return fmt.Sprintf("token(%s, %c)", typ, t.value)
}

type interpreter struct {
	text          string
	pos           int
	current_token token
}

func (interp *interpreter) get_next_token() token {
	text := interp.text
	if interp.pos > len(text) - 1 {
		return token{Eof, 0}
	}

	current_char := rune(text[interp.pos])
	if unicode.IsDigit(current_char) {
		token := token{Integer, int(current_char) - '0'}
		interp.pos += 1
		return token
	}

	if current_char == '+' {
		token := token{Plus, current_char}
		interp.pos += 1
		return token
	}

	panic("get next token error")
}

func (interp *interpreter) eat(typ token_type) {
	if interp.current_token.typ == typ {
		interp.current_token = interp.get_next_token()
	} else {
		fmt.Println(interp.current_token.typ, typ)
		panic("eat error")
	}
}

func (interp *interpreter) expr() int {
	interp.current_token = interp.get_next_token()

	left := interp.current_token
	interp.eat(Integer)

	op := interp.current_token
	fmt.Println("operation:", op)
	interp.eat(Plus)

	right := interp.current_token
	interp.eat(Integer)

	return left.value.(int) + right.value.(int)
}

func main() {
	var text string
	for {
		fmt.Print("calc> ")
		if _, err := fmt.Scanln(&text); err != nil {
			break
		}
		inter := &interpreter{text: text, pos: 0}
		fmt.Println(inter.expr())
	}
}
