package br.edu.ifba.sistema_moveleiro.cli;

import br.edu.ifba.sistema_moveleiro.domain.model.produto.Produto;
import br.edu.ifba.sistema_moveleiro.application.service.ProdutoService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

@Component                            // Spring executa na inicialização
@RequiredArgsConstructor              // Injeta ProdutoService via construtor
public class ProdutoCliRunner implements CommandLineRunner {
    /**
     * Feito pelo Chat GPT-4 By Breno e Igor
     * CLI para gerenciar produtos no sistema moveleiro.
     * Permite listar, cadastrar, atualizar e remover produtos.
     */
    private final ProdutoService service;
    private final Scanner sc = new Scanner(System.in);
    private final Random rand = new Random();

    @Override
    public void run(String... args) {
        seedProdutos();                               // ← dados-mock iniciais
        System.out.println("\n=== CLI MOCK — CONTROLE MOVELEIRO ===");
        loopMenu();
    }

    /* ------------------- Seed inicial ------------------- */
    private void seedProdutos() {
        if (!service.findAll().isEmpty()) return;     // evita duplicar

        List<Produto> mocks = List.of(
                novoProduto(1001, "Cadeira Gamer",
                        "Ergonômica, reclinável 180°",
                        "Preto/Vermelho", 999.90),
                novoProduto(2001, "Mesa Office",
                        "Mesa de MDF 1,20 m",
                        "Nogueira", 599.90),
                novoProduto(3001, "Estante Slim",
                        "4 prateleiras estilo industrial",
                        "Branco", 349.00)
        );
        mocks.forEach(service::save);
        System.out.println("🔰  Seed inserido: " + mocks.size() + " produtos.");
    }

    private Produto novoProduto(int code, String nome, String desc,
                                String cor, double preco) {
        Produto p = new Produto();
        p.setProductCode(code);
        p.setProductName(nome);
        p.setProductDescription(desc);
        p.setProductColor(cor);
        p.setProductPrice(preco);
        return p;
    }

    /* ------------------- Menu principal ------------------- */
    private void loopMenu() {
        while (true) {
            System.out.println("\n[1] Listar  [2] Cadastrar  "
                    + "[3] Atualizar  [4] Remover  [0] Sair");
            switch (sc.nextLine().trim()) {
                case "1" -> listar();
                case "2" -> cadastrar();
                case "3" -> atualizar();
                case "4" -> remover();
                case "0" -> {
                    System.out.println("👋 Encerrando CLI...");
                    return;
                }
                default -> System.out.println("⚠️  Opção inválida");
            }
        }
    }

    /* ------------------- Operações ------------------- */
    private void listar() {
        List<Produto> produtos = service.findAll();
        if (produtos.isEmpty()) {
            System.out.println("📭 Nenhum produto cadastrado.");
            return;
        }
        System.out.println("\n— Lista de Produtos —");
        produtos.forEach(p -> System.out.printf(
                "%d | %s | %s | R$ %.2f%n",
                p.getId(), p.getProductName(),
                p.getProductColor(), p.getProductPrice()
        ));
    }

    private void cadastrar() {
        Produto p = new Produto();
        System.out.print("Nome: ");
        p.setProductName(sc.nextLine());
        System.out.print("Descrição: ");
        p.setProductDescription(sc.nextLine());
        System.out.print("Cor: ");
        p.setProductColor(sc.nextLine());
        System.out.print("Preço: ");
        p.setProductPrice(leDouble());
        p.setProductCode(rand.nextInt(9000) + 1000);

        Produto salvo = service.save(p);
        System.out.printf("✔ Produto ID %d salvo!%n", salvo.getId());
    }

    private void atualizar() {
        System.out.print("ID do produto a atualizar: ");
        Long id = leLong();
        Produto existente = service.findById(id);

        System.out.printf("Novo nome (%s): ", existente.getProductName());
        String nome = sc.nextLine().trim();
        if (!nome.isBlank()) existente.setProductName(nome);

        System.out.printf("Nova descrição (%s): ", existente.getProductDescription());
        String desc = sc.nextLine().trim();
        if (!desc.isBlank()) existente.setProductDescription(desc);

        System.out.printf("Nova cor (%s): ", existente.getProductColor());
        String cor = sc.nextLine().trim();
        if (!cor.isBlank()) existente.setProductColor(cor);

        System.out.printf("Novo preço (%.2f): ", existente.getProductPrice());
        String precoStr = sc.nextLine().trim();
        if (!precoStr.isBlank()) existente.setProductPrice(Double.parseDouble(precoStr));

        service.update(id, existente);
        System.out.println("✔ Produto atualizado!");
    }

    private void remover() {
        System.out.print("ID do produto a remover: ");
        Long id = leLong();
        service.deleteById(id);
        System.out.println("🗑️  Produto removido.");
    }

    /* ------------------- Utilidades ------------------- */
    private double leDouble() {
        while (true) {
            try {
                return Double.parseDouble(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.print("Número inválido, digite novamente: ");
            }
        }
    }

    private long leLong() {
        while (true) {
            try {
                return Long.parseLong(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.print("Número inválido, digite novamente: ");
            }
        }
    }
}
