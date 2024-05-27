;; review of our clojure data structures so far
;; most basic data structure in clojure is lists
'(1 2 "hello")

;; add indexes, enter vectors
([1 2 "hi"] 2)

;; more sophisticated indexing: keys
;; enters hashmaps / dictionaries / lookup tables
(def m {"answer" 42
        "question" "?"
        2 "two",        ;; you can optionally add commas to delimit pairs
        "list" '(1 2)
        () '(3)})

;; querying hashmaps
(m "answer") ;; 42
(m ())       ;; (3)
(m "list")   ;; (1 2)
(m "none")   ;; nil

;;
(m "answer")
(m "answer" 42) ;; im not sure what does this usage mean

;; get all keys / vals as a list
(keys m)
(vals m)

(vals {}) ;; nil

;; we can use nil as a key
({nil "nothing"} nil)

;; grow a hashmap
(def grown-m (conj {"a" 1} ["b" 2]))
grown-m

(count grown-m) ;; 2, counts the pairs

;; zipmap, we can combine a bunch of keys and align them with a bunch of values
(zipmap [:a :b :c] [1 2 3])

;; another example
(def number-names ["zero" "one" "two" "three" "four" "five"])

(def number->name
  (zipmap
   (range 6)
   number-names))

(def name->number 
  (zipmap
   number-names
   (range 6)))

(name->number "two") ;; 2
(number->name 4)     ;; "four"

;; it is safe to a larger map as everything will be limited the smallest vector