(ns loja.aula5
  (:require [loja.db :as l.db]
            [loja.logic :as l.logic]))

(defn gastou-bastante?
  [info-do-usuario]
  (> (:preco-total info-do-usuario) 500)
  )
;keep é um mapa e um filter
(let [pedidos (l.db/todos-os-pedidos)
      resumo (l.logic/resumo-por-usuario pedidos)]
  ;O keep retorna o resultado da função
 (println "KEEP" (keep gastou-bastante? resumo))
 (println "FILTER" (filter gastou-bastante? resumo))
  )

(defn gastou-bastante?
  [info-do-usuario]
  (println "Gastou Bastante" (:usuario-id info-do-usuario))
  (> (:preco-total info-do-usuario) 500)
  )
(let [pedidos (l.db/todos-os-pedidos)
      resumo (l.logic/resumo-por-usuario pedidos)]
  ;O keep retorna o resultado da função
  (println "KEEP" (keep gastou-bastante? resumo))
  (println "FILTER" (filter gastou-bastante? resumo))
  )

(println "Vamos isolar...")

(println (range 10))
(println (take 2 (range 10000000000)))
(let [sequencia (range 100000)]
  (println (take 2 sequencia))
  (println (take 2 sequencia)))

; Clojure executa de maneira Lazy (Preguiçosa), não executa todo o array de uma vez

(defn filtro1 [x]
  (println "Filtro 1" x)
  x)
(defn filtro2 [x]
  (println "Filtro 2" x)
  x)

(println (map filtro1 (map filtro2 (range 10))))

;Eager - Tenta executar tudo de uma vez
(->> (range 50)
     (map filtro1)
     (map filtro2)
     println)

; Executa primeiro 1 depois a outra
(->> (range 50)
     (mapv filtro2)
     (mapv filtro1)
     println)

(->> [0 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7 8 9 0]
     (map filtro1)
     (map filtro2)
     println)



