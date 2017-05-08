(ns fc-prime.core)

(defn is-multiple? 
  "Finds if number is multiple of given prime" 
  [prime-num param]
   (= (mod param prime-num) 0))

(defn prime-sieve [num-primes coll]
  ())

(defn find-primes 
  "Finds desired number primes between 2 and a given max"
  ([] (find-primes 1000))
  ([range-max] (find-primes range-max 10))
  ([range-max num-primes] (prime-sieve (range 2 range-max))))
