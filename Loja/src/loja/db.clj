(ns loja.db)

(def pedido1 {:usuario-id 15
              :itens      {:mochila { :id :mochila, :quantidade 2, :preco-unitario 80}
                      :camiseta { :id :camiseta, :quantidade 3, :preco-unitario 40}
                      :tenis    { :id :tenis, :quantidade 1}}})

(def pedido2 {:usuario-id 1
              :itens      {:mochila { :id :mochila, :quantidade 2, :preco-unitario 80}
                      :camiseta { :id :camiseta, :quantidade 3, :preco-unitario 40}
                      :tenis    { :id :tenis, :quantidade 1}}})

(def pedido3 {:usuario-id 15
              :itens      {:mochila { :id :mochila, :quantidade 2, :preco-unitario 80}
                      :camiseta { :id :camiseta, :quantidade 3, :preco-unitario 40}
                      :tenis    { :id :tenis, :quantidade 1}}})

(def pedido4 {:usuario-id 15
              :itens      {:mochila { :id :mochila, :quantidade 2, :preco-unitario 80}
                      :camiseta { :id :camiseta, :quantidade 3, :preco-unitario 40}
                      :tenis    { :id :tenis, :quantidade 1}}})

(def pedido5 {:usuario-id 19
              :itens      {:mochila { :id :mochila, :quantidade 20, :preco-unitario 80}
                      :camiseta { :id :camiseta, :quantidade 3, :preco-unitario 40}
                      :tenis    { :id :tenis, :quantidade 1}}})
(def pedido6 {:usuario-id 20
              :itens      {:mochila { :id :mochila, :quantidade 2, :preco-unitario 80}
                      :camiseta { :id :camiseta, :quantidade 10, :preco-unitario 40}
                      :tenis    { :id :tenis, :quantidade 1}}})
(def pedido7 {:usuario-id 21
              :itens      {:mochila { :id :mochila, :quantidade 5, :preco-unitario 80}
                      :camiseta { :id :camiseta, :quantidade 14, :preco-unitario 40}
                      :tenis    { :id :tenis, :quantidade 3}}})

(defn todos-os-pedidos []
  [pedido1, pedido2, pedido3, pedido4, pedido5, pedido6, pedido7])