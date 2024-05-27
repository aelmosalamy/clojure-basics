;; keywords are powerful - and beautiful

;; create a keyword called :k
:k 
;; k is undefined

(def m {:a 1, :b 2})

;; we can apply our hashmap on the keyword to get its value
(m :a)
;; or a keyword can be also used as a function to look itself up!
(:a m)

(keys m) ;; (:a :b)

;; hashmap to build little databases / objects
(def book {:author "Douglas Adams"
           :title "Hitch-hiker's guide to the galaxy"
           :year 1979})

(:author book)
(:title book)
(:year book)
(:publisher book) ;; nil