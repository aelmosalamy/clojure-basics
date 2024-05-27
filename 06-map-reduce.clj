(map inc [1 2 3 4 5])

(defn hello [s] (str "hello " s "!"))

(hello "world") ;; hello world!

(map hello ["adham" "there"]) ;; ("hello adham!" "hello there!")

;; map itself yields a lazy evaluated sequence, hence this wont run infinitely
(take 20 (map dec (range)))

(map + [1 2 3] [10 20 30] [100 200 300])

(filter even? [0 0 2 93 1 8])
(filter even? (take 10 (range)))

;; filter with negated predicate
(remove even? [0 0 2 93 1 8])
(remove even? (take 10 (range))) ;; equivalent to (filter odd? ..)

(filter pos? [1 0 -1 2 0 0 8])

;; we can remove falsy values by filtering with the identity!
(filter identity [1 2 nil 32 false nil 1 0])

(and 1 nil 42) ;; returns nil
(or 42 nil)    ;; 42

;; how to get only true or false?
(boolean (and 1 nil 42)) ;; return false
(boolean (or 42 nil))    ;; returns true

;; reduce is the more generic, universal operation, it is capable of implementing both map and filter
;; (reduce (fn [result-so-far next-item]
;;         (compute-new-result result-so-far next-item)) initial-value collection)
;; reduce iteratively applies the next item to the result so far using some function

(reduce conj [1 2] [3 4 5])
;; return reduce intermediate steps
(reductions conj [1 2] [3 4 5])
;; reduce equivalent to
(conj (conj (conj [1 2] 3) 4) 5)

;; get the maximum value
(reduce max [1 2 3 4 -1 4 8 9 0 21])     ;; 21
(reductions max [1 2 3 4 -1 4 8 9 0 21]) ;; how 21 came to be

;; similar to apply in some cases
(reduce + [1 2 3 4]) ;; 6
(apply + [1 2 3 4])  ;; 6

;; how to write a reducing function? lets reimplement count
(defn my-count [coll]
  (reduce (fn [acc _] (inc acc))
          0
          coll))

(my-count [1 2 3])
(my-count "hello")
(my-count [])

;; conj, behavior is different based on underlying collection
(conj [1] 42)  ;; [1 42]
(conj '(1) 42) ;; (42 1)

;; historically, Lisp used cons (consolidate i guess?)
;; it is designed to work with lists and will always add to the beginning
(cons 1 [2 3])
(cons 1 '(2 3))