package br.edu.infnet.control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import br.edu.infnet.console.Teclado;
import br.edu.infnet.database.Conexao;

public class ControlCadastrar {
	
	public static Scanner sc = new Scanner(System.in);
	
	public static void cadastroVeiculo() {
	
		System.out.println("Informe os dados do ve�culo:");
		
		System.out.println("Chassi:");
		String chassi = sc.nextLine().toUpperCase();
		
		System.out.println("Montadora:");
		String montadora = sc.nextLine().toUpperCase();
		
		System.out.println("Modelo:");
		String modelo = sc.nextLine().toUpperCase();
		
		System.out.println("Tipo:");
		String tipo = sc.nextLine().toUpperCase();
		
		System.out.println("Cor:");
		String cor = sc.nextLine().toUpperCase();
		
		System.out.println("Motor:");
		String motor = sc.nextLine().toUpperCase();
		
		System.out.println("C�mbio:");
		String cambio = sc.nextLine().toUpperCase();
		
		System.out.println("Valor:");
		float preco = sc.nextFloat();
		
		try {
			
			Connection con = Conexao.getConexao();
			
	    	String sql = "INSERT INTO carro (chassi, montadora, modelo, tipo, cor, motor, cambio, preco )" +
	    	"VALUES (?,?,?,?,?,?,?,?)"; 
	    	    	
	    	PreparedStatement comando = con.prepareStatement(sql);
			
	    	comando.setString(1, chassi);
	    	comando.setString(2, montadora);
	    	comando.setString(3, modelo);
	    	comando.setString(4, tipo);
	    	comando.setString(5, cor);
	    	comando.setString(6, motor);
	    	comando.setString(7, cambio);
	    	comando.setFloat(8, preco);
	    	comando.executeUpdate();
	    	
	    	System.out.println("Ve�culo Registrado com sucesso!");
	    	
		} catch (SQLException e) {
			System.out.println("Processo abortado: " + e);
		}
	}
}



