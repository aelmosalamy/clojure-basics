;; pattern matching / destructuring

;; can we write the following function?
;; specification: (slope [[1 2] [2 4]])

;; naive way
(defn slope
  [line] 
  (/ 
   (- (second (second line)) 
      (second (first line)))
   (- (first (second line)) 
      (first (first line))))) 

;; works -> 2
(slope [[1 2] [2 4]])

;; problem, we are doing two things at the same time where, the
;; business logic is mingled with extraction of the aguments
;; lets do better
(defn slope2
  [line]
  
  (let [p1 (first line)
        p2 (second line)
        x1 (first p1)
        y1 (second p1)
        x2 (first p2)
        y2 (second p2)]
    (/ (- y2 y1)
       (- x2 x1))))

;; works -> 2
(slope2 [[1 2] [2 4]])

;; this is cleaner, but it is repetitive, it's a chore...
;; we can do better
(defn slope3
  [[[x1 y1] [x2 y2]]]

  (/ (- y2 y1)
     (- x2 x1)))

;; arguments are extracted just like they got provided,
;; similar to python and javascript's beautiful pattern matching
(slope3 [[1 2] [2 4]])

;; destructuring uses macros under the hood, we can see the generated
;; pattern using `destructure, could not get it to work

;; associative destructuring
(def m {:a 3 :b 5})

;; [3 5]
(let [{a :a b :b} m]
  [a b])