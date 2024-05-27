;; atom
1

;; function
(inc 1)
(dec 1)

;; call inc twice function
(inc (inc 1))

;; function composition
((comp inc inc) 1)

;; identity composition
((comp inc dec) 100)

;; identity function
(identity "hello, world")

;; multiple composititon
((comp inc inc inc inc) 0)

;; comp used alone is the identity
(comp 1)

;; prefix notation
(+ 1 2 3 4 5 6 7)
(* 2 3)

;; abstract algebra, sensible default adds to the identity
(+ 2)

;; additive identity
(+)

;; multiplicative identity
(*)

;; more tricky
(- 2 3 4)

;; 16 / 2 / 2 / 2
(/ 16 2 2 2)

;; order of precedence
(/ 2 (* 3 4))

;; Clojure is a hosted language, on top of the JVM. ClojureScript is a hosted language on top of Javascript
;; You are able to access language features from Java
Math/PI ;; returns 3.141...
(Math/cos Math/PI)

(Math/min 2 8)

;; predicate functions
(zero? 0)
(zero? (dec 2))
(pos? 4)
(neg? -19)
(< 0 1)

(< 0 1 2 3 4)  ;; true
(< 0 1 1 3 4)  ;; false
(<= 0 1 1 3 4) ;; true

(= 42 (inc 41) (dec 43))

;; type is important, it determines what you do with objects
;; types are not set in stone but rather decisions of the language
(number? 42)   ;; true
(number? inc)  ;; false
(fn? +)        ;; true
(fn? inc)      ;; true
(integer? 3)   ;; true
(integer? 3.0) ;; false, ClojureScript would return true since it is based on Javascript's loose type system
(float? 3.0)   ;; true
(float? 3)     ;; false

;; symbolic fractions
(rational? (/ 1 2)) ;; true
(rational? 0.5)     ;; false
;; symbolic fractions are different from floats
(= (/ 1 2) 0.5)     ;; false
(== (/ 1 2) 0.5)    ;; true