(vector 1 2 3 4)

(vector [1 2 3])

(vec '(1 2 3))

(hash-map :a 1 :b 2)
;; (hash-map :a 1 :b) will fail

(hash-set 1 2 3)
(hash-set 1 2 3 2)

(set '(1 2 2 3 3)) ;; #{1 3 2}
(list [1 2 3])     ;; ([1 2 3])
(seq [1 2 3])      ;; (1 2 3)