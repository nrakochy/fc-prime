(ns fc-prime.core)

(defn is-not-multiple? 
  "Finds if number is not a multiple of given prime" 
  [param prime-num]
   (not= (mod param prime-num) 0))

(defn filter-multiples [reduced-coll]
  (filter #(is-not-multiple? % (first reduced-coll)) (rest reduced-coll)))

(defn terminate-prime-finder? [num-primes results coll]
  (or (= (count results) num-primes) (empty? coll)))

(defn prime-sieve [num-primes coll]
    (loop [num-primes num-primes
           results []
           reduced-coll coll]
      (if (terminate-prime-finder? results num-primes reduced-coll) 
        results
        (recur num-primes (conj results (first reduced-coll)) (filter-multiples reduced-coll)))))

(defn find-primes 
  "Finds desired number primes between 2 and a given max"
  ([] (find-primes 1000))
  ([range-max] (find-primes range-max 10))
  ([range-max num-primes] (prime-sieve num-primes (range 2 range-max))))
