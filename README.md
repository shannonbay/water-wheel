# water-wheel
Water Wheel - dynamic stream processing for Java

As a stream flows, the water wheel turns.  The machinery is stateful and steps forward to a new state on each new input.  This is exactly what happens in a regular
expression engine or a deterministic finite automata (which can parse a wider class of languages than regular languages).

Get the power and flexibility of regular languages and parser generators in your stream and reactive apps.

An easy to use parser generator. Intended for use in concurrent applications such as protocol stacks, domain-specific languages (DSL) and rules engines.

Use water-wheel to extend [jStatePool](http://github.com/shannonbay/jStatePool) event-driven business rules with sequence predicates. Add some connections and you've got the basis for a flexible message broker.

Includes a fast SIP (Session Initiation Protocol) Lexer/Parser for demonstration and testing purposes. (TODO)

This implementation minimises garbage creation by generating an immutable non-deterministic PDA with an equivalent computational complexity to the pure derivatives approach taken by Matt Might and David Darais.  This is because the parser only generates derivative sub-trees when entering a recursive reference, otherwise it uses a fast NFA.

## Acknowledgements
- [Matt Might](https://matt.might.net/articles/parsing-with-derivatives/)
- [Daniel Darais](http://david.darais.com/)
- [Daniel Spiewak](http://www.codecommit.com/blog/) | [Derivative Parsing](http://www.cs.uwm.edu/~dspiewak/papers/derivative-parsing.pdf)
## Features

- Unified Parser/Lexer definition
    - Inline actions alongside Lexer/Parser rules (TODO)
    - Build an AST or any other output from a good parse (TODO)
- LR Grammar supported (TODO)
- BNF syntax using Scala operator overrides
    - Catenation (a ~ b)
    - Kleene Star Repetition (a*) (TODO)
    - Optional (a?) (TODO)
    - Literals as char or String ('a' or "literal")
    - Numbered Repetition (^n, eg ^2 for two in a row) (TODO)
    - Disjunction (a | b)
    - Recusive rules including LR ( val A ||= Late(A) ~ a) (TODO)
    - Easily extensible rules
 - Java Library
 - Code generator (TODO)
 - Thread-safe and fast for highly concurrent applications
 - Integrates with the jStatePool session management library

## Authors

- [@shannonbay](https://www.github.com/shannonbay)

