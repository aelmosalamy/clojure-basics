;; lets declare a global variable
(def v [1 2 3])

v          ;; [1 2 3]

(conj v 4) ;; [1 2 3 4]

;; v is unchanged, there is no side effects done by conj!
v          ;; [1 2 3]

;; clojure performs structural sharing to keep this immutability efficient
;; adding 1 element to a 1m element vector will not naively allocate extra
;; 1m elements to a new variable

;; lets talk about side effects
(str 42)

;; rand is not a pure function
(rand)

;; println returns `nil`, however it has the side effect
;; of printing to the screen hence it is not pure
(println "hello, world")

;; returns the last returned value
(do (inc 1) (inc 2))

;; `doseq` returns `nil` always, it is like `for` exactly but it is meant
;; to perform a side effect
(doseq [a [1 2]
        b [:x :y]]
  [a b])

(defn f [x]
  (def m 2) ;; never do this!
  (+ x m))

;; eliminate side effects -> clojure will help you minimize them
;; however, the real world will always require side effects ->
;; think graphics..