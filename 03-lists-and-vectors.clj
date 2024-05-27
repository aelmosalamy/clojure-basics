(comment
  ;; (1 2 3 4 5) ;; this will fail, 1 is not a function, parantheses denote "there is work to do inside" 
  :rcf)

'(1 2 3 4 5)        ;; solution? quoting
'(inc 1)            ;; returns a list containing the function `inc` and the literal `1`
;; equivalent to
(quote (1 2 3 4 5)) ;; quote is not a function, it is a special keyword?

(list 1 2 3 4 5)    ;; make a list of the following arguments
(list inc "hello" 42 1.3)

;; lists grow from the front, it is very awkward, limited data structure
;; they are clojure's linked list implementation
(cons 1 '(2 3 4 5))

;; get the first element
(first '(1 2 3 4))
(rest '(1 2 3 4))
(first (rest '(1 2 3 4)))

(first ()) ;; -> nil
(rest ())  ;; -> ()

(concat '(1 2) '(3 4) () '(5))

(count '(1 2 3 4 5))

;; (5 4 3 2 1)
(reverse '(1 2 3 4 5))

(last '(1 2 3 4 5))

;; get the last element
((comp first reverse) '(1 2 3 4 5))

;; vectors
[1 2 3 4]

[1 "two" 3]

(vector 1 2 3 4 inc) ;; create a vector out of arguments
(vec '(1 2 3))       ;; convert a collection to a vector

;; indexing
(nth [1 "two" 3], 1)
(nth [1 "two" 3], 0) ;; vectors are 0-indexed
(nth [1 "two" 3], 4) ;; out-of-bound index

;; a vector is nothing but a function. It maps index values to the stored data values
;; hence we can use it as such! we do not need `nth`
([42 "hello" 0.19 1/2] 2)
;; if it is indeed a function, then we must be able to compose them!
((comp ["apple" "mango" "banana"] [1 0 2 1]) 3) ;; equivalent to fruits[indexes[3]], I have the feeling this is very powerful