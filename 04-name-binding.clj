;; (+ x 1) ;; unable to resolve symbol: x in this context

(def x 1)
(+ x 1)

;; actually using (def x 1) is not good for this use case, it is polluting the environment
;; we should use symbol bindings instead
(let [x 2] (+ x 1))
(let [x 2, y 3] (+ x y))