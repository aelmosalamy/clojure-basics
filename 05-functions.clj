(* 13 13)
(* 1313 1313)
(* 131313 131313)

;; use binding to make some sort of abstract expression
(let [x 131313] (* x x))
(let [x 272727] (* x x))

;; we can define a function and apply it to 13
((fn [x] (* x x)) 13)

;; why not give it a name?
(def sq (fn [x] (* x x)))
(sq 11)
(sq 58334)

;; defining functions is common, so we have a keyword for that
(defn sq2 [x] (* x x))
(sq2 -1)

;; lambda functions
(defn add3 [n] (+ 3 n))
(add3 10)
(add3 -3)

(map add3 [1 2 3 4 5])
;; but we dont wanna name every function we use, especially if it is used once
;; lets do better:
(map (fn [n] (+ 3 n)) [1 2 3 4 5])
;; we can do even better using lambda:
(map #(+ 3 %) [1 2 3 4 5])

;; can we do more than 1 argument?
(map #(+ %1 %2 10) [1 2] [3 4])

;; we can omit the number for the first argument
(map #(+ % %2 10) [1 2] [3 4])

;; manual function call
(max 1 2 3 -1 928 17) ;; 928
;; (max [2 4 5 1 7 3 0]) ;; [2 4 5 1 7 3 0]

;; how do we solve this?
(apply max [2 4 5 1 7 3 0]) ;; 7

;; one more,
;; (+ [10 12 4]) errors out.
(apply + [10 12 4])

;; apply takes a function and a vector/list and it calls the function 
;; with these elements as arguments
;; (apply f [x y z]) --> (f x y z)
;; technically unpacks the vector and performs a manual function call

(defn bigger-than-max [coll] (inc
                              (apply max coll)))
(bigger-than-max [9 2 1])

;; lazy sequences, like a child asked to show their homework. work is done only when
;; absolutely required
(range 10) ;; (0 1 2 3 4 5 6 7 8 9)
(range 0.012 5)

;; (range) ;; infinite sequence - lets not run that in our repl
;; we can however "take" from it, similar to generators in python (technically it is)
(def natural-numbers (range))
(take 5 natural-numbers)
(take 20 natural-numbers) ;; => (0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19)

;; skip 5 from the sequence, then take 5 from there
(take 5 (drop 5 natural-numbers)) ;; returns 5 6 7 8 9

;; keep taking as long as the predicate is true (front only as it stops working once condition is falsified)
(take-while neg? [-2 -1 -1 0 -1 1 2])

;; drop as long as the predicate is true (same behavior)
(drop-while neg? [-2 -1 -1 0 -1 1 2])

(drop-while zero? [1 0 0 0]) ;; [1 0 0 0]

;; problem of function not called
str 42 "number"    ;; a bunch of valuee
(str 42 " number") ;; a function call

;; can be tricky to debug as your code and parantheses get complex
(defn g
  [name]
  str "hey " name "!")

;; static analyzer will catch the above most likely, fix:
(defn h
  [name]
  (str "hey " name "!"))
(h "adham") ;; "hey adham!"

;; describing functions with disregard to their inputs
;; interesting topic
;; function composition is an example of that, we never had to mention the arguments!
(def negative-product (comp - *))
(negative-product 1 2 3 4 5)

;; partial
(def ten-times (partial * 10))
(map ten-times [1 2 3 45])

;; `juxt` / juxtaposition / contrasting things
((juxt take drop) 3 [1 2 3 4 5 6 7 8])

(def book {:author "Dan Brown"
           :title "The Davinci Code"
           :year 2009
           :category "Fiction"})

((juxt :title :year) book)

;; separate even and odd numbers
(def f (juxt (partial filter even?) (partial filter odd?)))
(f (range 10)) ;; -> produces two lists, one of evens and one of odds

;; count lowercase characters
(def count-if (comp count filter))
(def letters (set "abcdefghijklmnopqrstuvwxyz"))
(def count-lowercase (partial count-if letters))
(count-lowercase "hash__ Q!#$!AAm19292")

;; golden ratio
(take 5 (iterate (comp inc /) 1))