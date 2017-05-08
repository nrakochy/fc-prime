(ns fc-prime.core)

(defn is-multiple? 
  "Finds if number is multiple of given prime" 
  [prime-num param]
   (= (mod param prime-num) 0))
