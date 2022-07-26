(ns loja.aula2)

(defn conta
  [total-ate-agora elementos]
  (conta (inc total-ate-agora) (rest elementos))
  )

(defn conta
  [total-ate-agora elementos]
  (if (next elementos)
  (conta (inc total-ate-agora) (rest elementos))
  total-ate-agora))

(defn conta
  [total-ate-agora elementos]
  (if (seq elementos)
    (recur (inc total-ate-agora) (next elementos))
    total-ate-agora))

(defn conta
  ([elementos]
   (conta 0 elementos))

  ([total-ate-agora elementos]
  (if (seq elementos)
    (recur (inc total-ate-agora) (next elementos))
    total-ate-agora)))

;LOOP
; for total-ate-agora 0, elementos-restantes elementos-restantes   ;; 1 next

(defn conta
  [elementos]
  (loop [total-ate-agora 0
         elementos-restantes elementos]
    (if (seq elementos-restantes)
      (recur (omc total-ate-agora) (next elementos-restantes))
      total-ate-agora)))

(println (conta ["daniela" "guilherme" "carlos" "paulo" "lucia" "ana"]))
(println (conta []))