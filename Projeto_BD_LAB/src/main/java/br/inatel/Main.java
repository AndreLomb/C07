package br.inatel;

import br.inatel.DAO.GuildaDAO;
import br.inatel.DAO.HunterDAO;
import br.inatel.DAO.WeaponDAO;
import br.inatel.Model.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static GuildaDAO guildDAO = new GuildaDAO();
    private static HunterDAO hunterDAO = new HunterDAO();
    private static WeaponDAO weaponDAO = new WeaponDAO();

    public static void main(String[] args) {
        exibirMenuPrincipal();
    }

    private static void exibirMenuPrincipal() {
        int opcao;
        do {
            System.out.println("\n===== MENU PRINCIPAL =====");
            System.out.println("1. Gerenciar Guildas");
            System.out.println("2. Gerenciar Caçadores");
            System.out.println("3. Gerenciar Armas");
            System.out.println("4. Listar Todas as Guildas");
            System.out.println("5. Listar Todos os Caçadores");
            System.out.println("6. Listar Todas as Armas");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar buffer

            switch (opcao) {
                case 1:
                    menuGuilda();
                    break;
                case 2:
                    menuCacador();
                    break;
                case 3:
                    menuArma();
                    break;
                case 4:
                    listarGuildas();
                    break;
                case 5:
                    listarCacadores();
                    break;
                case 6:
                    listarArmas();
                    break;
                case 0:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }

    private static void menuGuilda() {
        int opcao;
        do {
            System.out.println("\n===== MENU GUILDA =====");
            System.out.println("1. Cadastrar Guilda");
            System.out.println("2. Atualizar Guilda");
            System.out.println("3. Excluir Guilda");
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    cadastrarGuilda();
                    break;
                case 2:
                    atualizarGuilda();
                    break;
                case 3:
                    excluirGuilda();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }

    private static void cadastrarGuilda() {
        System.out.println("\n--- CADASTRAR GUILDA ---");

        System.out.print("ID da Guilda: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("Poções: ");
        String pocoes = scanner.nextLine();

        System.out.print("Vestimentas: ");
        String vestimentas = scanner.nextLine();

        System.out.print("Armas: ");
        String armas = scanner.nextLine();

        Guilda guilda = new Guilda(id, nome, pocoes, vestimentas, armas);
        if (guildDAO.insertGuilda(guilda)) {
            System.out.println("Guilda cadastrada com sucesso!");
        } else {
            System.out.println("Erro ao cadastrar guilda!");
        }
    }

    private static void atualizarGuilda() {
        System.out.println("\n--- ATUALIZAR GUILDA ---");

        System.out.print("ID da Guilda a ser atualizada: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Novo Nome: ");
        String nome = scanner.nextLine();

        System.out.print("Novas Poções: ");
        String pocoes = scanner.nextLine();

        System.out.print("Novas Vestimentas: ");
        String vestimentas = scanner.nextLine();

        System.out.print("Novas Armas: ");
        String armas = scanner.nextLine();

        Guilda guilda = new Guilda(id, nome, pocoes, vestimentas, armas);
        if (guildDAO.updateGuilda(guilda)) {
            System.out.println("Guilda atualizada com sucesso!");
        } else {
            System.out.println("Erro ao atualizar guilda!");
        }
    }

    private static void excluirGuilda() {
        System.out.println("\n--- EXCLUIR GUILDA ---");

        System.out.print("ID da Guilda a ser excluída: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        if (guildDAO.deleteGuilda(id)) {
            System.out.println("Guilda excluída com sucesso!");
        } else {
            System.out.println("Erro ao excluir guilda!");
        }
    }

    private static void menuCacador() {
        int opcao;
        do {
            System.out.println("\n===== MENU CAÇADOR =====");
            System.out.println("1. Cadastrar Caçador");
            System.out.println("2. Atualizar Caçador");
            System.out.println("3. Excluir Caçador");
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    cadastrarCacador();
                    break;
                case 2:
                    atualizarCacador();
                    break;
                case 3:
                    excluirCacador();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }

    private static void cadastrarCacador() {
        System.out.println("\n--- CADASTRAR CAÇADOR ---");

        System.out.print("ID do Caçador: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("Rank: ");
        String rank = scanner.nextLine();

        System.out.print("Materiais Coletados: ");
        String materiais = scanner.nextLine();

        System.out.print("ID da Guilda: ");
        int guildaId = scanner.nextInt();
        scanner.nextLine();

        Cacador cacador = new Cacador(id, nome, rank, materiais, guildaId);
        if (hunterDAO.insertCacador(cacador)) {
            System.out.println("Caçador cadastrado com sucesso!");
        } else {
            System.out.println("Erro ao cadastrar caçador!");
        }
    }

    private static void atualizarCacador() {
        System.out.println("\n--- ATUALIZAR CAÇADOR ---");

        System.out.print("ID do Caçador a ser atualizado: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Novo Nome: ");
        String nome = scanner.nextLine();

        System.out.print("Novo Rank: ");
        String rank = scanner.nextLine();

        System.out.print("Novos Materiais Coletados: ");
        String materiais = scanner.nextLine();

        System.out.print("Novo ID da Guilda: ");
        int guildaId = scanner.nextInt();
        scanner.nextLine();

        Cacador cacador = new Cacador(id, nome, rank, materiais, guildaId);
        if (hunterDAO.updateCacador(cacador)) {
            System.out.println("Caçador atualizado com sucesso!");
        } else {
            System.out.println("Erro ao atualizar caçador!");
        }
    }

    private static void excluirCacador() {
        System.out.println("\n--- EXCLUIR CAÇADOR ---");

        System.out.print("ID do Caçador a ser excluído: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        if (hunterDAO.deleteCacador(id)) {
            System.out.println("Caçador excluído com sucesso!");
        } else {
            System.out.println("Erro ao excluir caçador!");
        }
    }

    private static void menuArma() {
        int opcao;
        do {
            System.out.println("\n===== MENU ARMA =====");
            System.out.println("1. Cadastrar Arma");
            System.out.println("2. Atualizar Arma");
            System.out.println("3. Excluir Arma");
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    cadastrarArma();
                    break;
                case 2:
                    atualizarArma();
                    break;
                case 3:
                    excluirArma();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }

    private static void cadastrarArma() {
        System.out.println("\n--- CADASTRAR ARMA ---");

        System.out.print("ID da Arma: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("Tipo: ");
        String tipo = scanner.nextLine();

        System.out.print("Materiais: ");
        String materiais = scanner.nextLine();

        System.out.print("Rank: ");
        String rank = scanner.nextLine();

        System.out.print("Estado de Afiação: ");
        int estado = scanner.nextInt();
        scanner.nextLine();

        Arma arma = new Arma(id, nome, tipo, materiais, rank, estado);
        if (weaponDAO.insertArma(arma)) {
            System.out.println("Arma cadastrada com sucesso!");
        } else {
            System.out.println("Erro ao cadastrar arma!");
        }
    }

    private static void atualizarArma() {
        System.out.println("\n--- ATUALIZAR ARMA ---");

        System.out.print("ID da Arma a ser atualizada: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Novo Nome: ");
        String nome = scanner.nextLine();

        System.out.print("Novo Tipo: ");
        String tipo = scanner.nextLine();

        System.out.print("Novos Materiais: ");
        String materiais = scanner.nextLine();

        System.out.print("Novo Rank: ");
        String rank = scanner.nextLine();

        System.out.print("Novo Estado de Afiação: ");
        int estado = scanner.nextInt();
        scanner.nextLine();

        Arma arma = new Arma(id, nome, tipo, materiais, rank, estado);
        if (weaponDAO.updateArma(arma)) {
            System.out.println("Arma atualizada com sucesso!");
        } else {
            System.out.println("Erro ao atualizar arma!");
        }
    }

    private static void excluirArma() {
        System.out.println("\n--- EXCLUIR ARMA ---");

        System.out.print("ID da Arma a ser excluída: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        if (weaponDAO.deleteArma(id)) {
            System.out.println("Arma excluída com sucesso!");
        } else {
            System.out.println("Erro ao excluir arma!");
        }
    }

    private static void listarGuildas() {
        System.out.println("\n--- LISTA DE GUILDAS ---");
        ArrayList<Guilda> guildas = guildDAO.selectGuildas();

        if (guildas.isEmpty()) {
            System.out.println("Nenhuma guilda cadastrada!");
        } else {
            for (Guilda g : guildas) {
                System.out.println("ID: " + g.getIdGuilda() + " | Nome: " + g.getNome());
                System.out.println("Poções: " + g.getPocoes());
                System.out.println("Vestimentas: " + g.getVestimentas());
                System.out.println("Armas: " + g.getArmas());
                System.out.println("----------------------------------");
            }
        }
    }

    private static void listarCacadores() {
        System.out.println("\n--- LISTA DE CAÇADORES ---");
        ArrayList<Cacador> cacadores = hunterDAO.selectCacadores();

        if (cacadores.isEmpty()) {
            System.out.println("Nenhum caçador cadastrado!");
        } else {
            for (Cacador c : cacadores) {
                System.out.println("ID: " + c.getIdGuerreiro() + " | Nome: " + c.getNome());
                System.out.println("Rank: " + c.getRank());
                System.out.println("Materiais Coletados: " + c.getMateriaisColetados());
                System.out.println("ID da Guilda: " + c.getGuildaId());
                System.out.println("----------------------------------");
            }
        }
    }

    private static void listarArmas() {
        System.out.println("\n--- LISTA DE ARMAS ---");
        ArrayList<Arma> armas = weaponDAO.selectArmas();

        if (armas.isEmpty()) {
            System.out.println("Nenhuma arma cadastrada!");
        } else {
            for (Arma a : armas) {
                System.out.println("ID: " + a.getIdArma() + " | Nome: " + a.getNome());
                System.out.println("Tipo: " + a.getTipo());
                System.out.println("Materiais: " + a.getMateriais());
                System.out.println("Rank: " + a.getRank());
                System.out.println("Estado de Afiação: " + a.getEstadoAfiacao());
                System.out.println("----------------------------------");
            }
        }
    }
}