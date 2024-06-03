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

;; we can not talk about strings without mentioning regex
;; regex patterns can be made using the convenience #"" literal
;; or through converting a string using re-pattern.
(re-pattern "pattern.*")
#"pattern.*" ;; #"pattern.*"

;; we will use the regex literal for brevity
(re-matches #".*fox.*" "the lazy brown fox") ;; "the lazy brown fox"

(re-matches #".*fox.*" "the lazy brown cat") ;; nil

(re-matches #".*(f.{2,}).*" "the lazy brown fox")

(re-matches #".*(fox).*" "The Lazy Brown Fox")

;; clojure accepts the common regex flags enclosed in a (?) form
;; before the pattern
(re-matches #"(?i).*(fox).*" "The Lazy Brown Fox")
