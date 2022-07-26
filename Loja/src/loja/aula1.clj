(ns loja.aula1)

;map - Passar por varias elementos de uma coleção
;reduce - Reduzir elementos para um resultado
;filter - filtrar algum valor

(map println ["Daniela","Guilherme","Vanessa"])
;Trás apenas o primeiro elemento
(println (first ["Daniela","Guilherme","Vanessa"]))
;Rest não
(println (rest ["Daniela","Guilherme","Vanessa"]))
;Next daria para descobrir quando uma colecção acaba
(println (next ["Daniela","Guilherme","Vanessa"]))

;Recursão é um recurso quando dentro de uma função chamamos ela mesma
(defn meu-mapa
  [funcao sequencia]
  (let [primeiro (first sequencia)]
    (if (not (nil? primeiro))
      (do
        (funcao primeiro)
        (meu-mapa funcao (rest sequencia))))))

(meu-mapa println ["Daniela","Guilherme","Vanessa"])
;TAIL RECURSION
(defn meu-mapa
  [funcao sequencia]
  (let [primeiro (first sequencia)]
    (if (not (nil? primeiro))
      (do
        (funcao primeiro)
        (recur funcao (rest sequencia))))))

(meu-mapa println (range 256))