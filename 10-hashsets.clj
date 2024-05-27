;; introducing hashsets, an unordered collection
(def numbers #{3 5 0})

;; test membership
(numbers 3) ;; 3
(numbers 4) ;; nil

;; return a default on non-membership
(get numbers 34 :default)

(def vegetables #{:cucumber :tomato :onion :carrot})
(def basket [:apple :apple :onion :carrot :grapes])

(filter vegetables basket)
(remove vegetables basket)