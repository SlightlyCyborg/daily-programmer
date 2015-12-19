(ns game-of-threes.core)

(defn game-of-threes [x]
  (if (= x 1)
    (println 1)
    (if (= 0 (mod x 3))
      (do
        (println (str x " " 0))
        (game-of-threes (/ x 3))) 
      (if (= 1 (mod x 3))
        (do 
          (println (str x " " -1))
          (game-of-threes (/ (- x 1) 3)))
        (do
          (println (str x " " 1))
          (game-of-threes (/ (+ x 1) 3)))))))

(game-of-threes 31337357)
