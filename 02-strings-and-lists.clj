;; let's do some strings
"hello, world"

;; a character is denoted by the \
(str \h \e \l \l \o)

(= \h "h")       ;; false, a char h is different from string h
(= (str \h) "h") ;; true

(str) ;; returns string identity, the empty string: ""

(= 42 "42")

"(inc 1)"

;; import clojure string library
(require '[clojure.string :as string])

(string/upper-case "hello")
(string/lower-case "HEY THERE")

;; some string predicate functions
(string? "hello")
(string/ends-with? "hello" "lo")

(string/replace "banana and mango" "an", "um")
(string/replace "banana" "an" "anan")