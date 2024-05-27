;; factorial, incredibly beautiful
(reduce * (range 1 6)) ;; 120
(apply * (range 1 6))  ;; 120

;; in python for example, thats how we do it
;;   from functools import reduce
;;   reduce(lambda acc, x: acc*x, range(1, 6), 1)

;; recursive factorial
(defn fact [n] (cond
                 (neg? n) nil
                 (== n 0) 1
                 :else (* n (fact (- n 1)))))

(fact 5) ;; 120

;; tower of hanoi
(defn hanoi [n source target spare]
  (if (= 1 n)
    (str " " source "->" target " ")
    (str
     (hanoi (dec n) source spare target)
     (str " " source "->" target " ")
     (hanoi (dec n) spare target source)
     )))

;; it works!
(hanoi 1 :a :b :c)
(hanoi 2 :a :b :c)
(hanoi 3 :a :b :c)
(hanoi 10 :a :b :c)