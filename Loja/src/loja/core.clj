(ns loja.core)

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

(defn meu-mapa
  [funcao sequencia]
   (let [primeiro (first sequencia)]
     (if (not (nil? primeiro))
     (do
       (funcao primeiro)
     (meu-mapa funcao (rest sequencia))))))

(meu-mapa println ["Daniela","Guilherme","Vanessa"])
