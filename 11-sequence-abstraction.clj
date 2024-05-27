;; whatever data structure we have list, vector, hashmap, hashset, string
;; we can reason about them as abstract sequences.
(seq '(1 2 3 4))
(seq [1 2 3 4])
(seq "hello, world")
(seq #{1 2 3 4})

(seq (set (range 1 20)))
(seq {:a 1 :b 2})        ;; returns ([:a 1] [:b 2])

(map first {:a 1 :b 2})   ;; returns the keys
(map second {:a 1 :b 2}) ;; returns the values

;; we can use iteration to build sequences
(take 10 (iterate inc 0))
(take 10 (iterate (fn [x] (+ (* x 2) 3)) 0))

;; get the direct product of [:a :b :c] and [1 2 3]
(map ;; we could also use `mapcat` although im not aware of the difference
 (fn [v] (map #(conj v %) [1 2 3]))
 (map vector [:a :b :c]))
;; produces the vector product of the two vectors

;; a cleaner way of achieving the above, for will iteratively bind [:a :b :c] to `a`
;; and so on for `b` and `c`, returning [a b c] for each iteration
(for [a [:a :b :c]
      b [1 2 3]
      c ["one" "two"]]
  [a b c])

(for [x (range 1 3)
      y (range 1 4)] 
  [x y])

(for [x (range 1 4)
      y (range 1 4)
      :when (<= x y)]
  [x y])

;; when x = 1 it will break the whole thing
(for [x (range 3) :while (not= x 1)
      y (range 3)]
  [x y])

;; the break will happen on y for values of x = 1
(for [x (range 3)
      y (range 3) :while (not= x 1)]
  [x y])

;; `for` it is own mini language within clojure
;; it is beautiful and extremely expressive