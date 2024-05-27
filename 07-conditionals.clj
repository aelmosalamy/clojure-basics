(not true)
(not false)

;; short-circuit evaluation of logic
(and true false true)
(or false false true)

;; only false and nil are falsy. Everything else is truthy (including an empty list)
(boolean 0)

(defn my-abs
  [x]
  (if (>= x 0) x
      (- x)))

(my-abs -2)
(my-abs 1)

;; cond is more general, helps as avoid many nested ifs
(defn what-is-it
  [x]
  (cond
    (float? x) "A float!"
    (number? x) "A number!"
    (char? x) "A char!"
    (string? x) "A string!"
    (fn? x) "A function!"
    ;; we could also use true for a catch all
    :else "I don't know"))

(what-is-it what-is-it)
(what-is-it 1.3)
(what-is-it 13)
(what-is-it \A)
(what-is-it ())