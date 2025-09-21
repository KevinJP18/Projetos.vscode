import java.awt.Color;//gerar cores na janela
import java.awt.Font;//aumenta tamanho da fonte
import java.security.MessageDigest;//processo de criptografa
import javax.crypto.SecretKey;//gera uma nova chave
import java.nio.charset.StandardCharsets;//gerar os numeros bytes em textos
import java.util.ArrayList;//listas
import java.util.Base64;//transforma numeros binarios em textos légiveis
import java.util.HashMap;//gerar valores e chaves 
import javax.crypto.Cipher;//algoritmo onde serve para criptografa ou descriptografa a mensagem
import javax.crypto.KeyGenerator;//gerar chaves secretas
import javax.swing.JButton;//gerar botoes
import javax.swing.JFrame;// gerar janelas
import javax.swing.JLabel;// gerar textos
import javax.swing.JOptionPane;// gerar interface
import javax.swing.JTextArea;//gerar comentarios longos
import javax.swing.JTextField;//gerar comentarios curtos
import java.awt.event.ActionEvent;//esse gera os eventos quando o botão é clicado
import java.awt.event.ActionListener;//esse serve para caso botão for clicado ele gera o que esta na configuração/reação
    public class login extends JFrame {//necessario para assim a classe gerar janelas,comportamentos etc...
        private SecretKey chaveGlobal;//foi criado para cada usuário ter sua própria chave
         static HashMap<String, String> map = new HashMap<>();//armazenando nome e senha do usuario/salva 
         static ArrayList<Mensagem> mensa = new ArrayList<>();//salvando as mensagens
         static class Mensagem{//metodo que guarda,indica e envia a mensagem.
            String remetente;
            String destinatario;
            String conteudoCriptografado;
            SecretKey chaveUsada;
            Mensagem(String de, String para, String conteudo, SecretKey chaveUsada){//metodo que cria a mensagem
                this.remetente = de;
                this.destinatario = para;
                this.conteudoCriptografado = conteudo;
                this.chaveUsada = chaveUsada;
            }
         }
         JFrame log;
         JTextField texto;
         JTextField text;
        public login() {
        JFrame log = new JFrame();
            log.setTitle("Tela de Login");
                log.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//X para fecha a pagina sem erro
                    log.setSize(600, 500);//tamanho da janela
                log.getContentPane().setBackground(Color.WHITE);//cor da janela
            log.setLocationRelativeTo(null);//centraliza a janela
        log.setLayout(null);//organização em null
    JLabel mensagem = new JLabel("Login e Senha");//faz a mensagem na tela aparace
    mensagem.setFont(new Font("Arial", Font.BOLD, 20));//tamanho da mensagem
        mensagem.setBounds(80,70,300,40); //tipo layout 
            log.add(mensagem);
    JLabel login = new JLabel("Login: "); //imprimir
        login.setBounds(30,180,60,25);
            log.add(login);
    JLabel senha = new JLabel("Senha: ");
        senha.setBounds(30,250,80,25);
            log.add(senha);
     texto = new JTextField(); //entrada de dados
        texto.setBounds(68,179,100,25);
            log.add(texto);
    text = new JTextField();
        text.setBounds(71,250,100,25);
            log.add(text);
    JButton botao = new JButton("avançar"); // Botão avançar
        botao.setBounds(200,300,120,40);
            log.add(botao);
    try{
        //gerou o nome em Bytes
            MessageDigest gerador = MessageDigest.getInstance("SHA-256"); 
                byte[] hashBytes = gerador.digest("admin".getBytes());
                    StringBuilder builder = new StringBuilder();
                        for(byte b : hashBytes)//hexa
                            builder.append(String.format("%02x", b));
            MessageDigest gerador1 = MessageDigest.getInstance("SHA-256");
                byte[] hashBytes1 = gerador1.digest("admin".getBytes());
                    StringBuilder builder2 = new StringBuilder();
                        for(byte a : hashBytes1)
                            builder2.append(String.format("%02x", a)); 
    }catch(Exception e){
        e.printStackTrace();
    }
    //aprendendo e perdendo cabeça a configurar um botao
    botao.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e){
            String loginUsuario = texto.getText();
            String senhaUsuario = text.getText();
             if("admin".equals(text.getText()) && "admin".equals(texto.getText())){
                texto.setText(" ");
                text.setText(" ");
                log.dispose();// fecha a tela de login e "atualizar" para a proxima pagina
                    JFrame fram = new JFrame();//nova janelinha
                        fram.setTitle("Tela Principal");//nome da janela
                            fram.setSize(600, 500);//tamanho da janela
                                fram.getContentPane().setBackground(Color.WHITE);//cor da janela
                            fram.setLocationRelativeTo(null);//faz a janela fica no meio do pc
                        fram.setLayout(null);
                    JLabel l = new JLabel("Bem-Vindo");//mensagem
                l.setFont(new Font("Arial", Font.PLAIN, 20));//tamanho da mensagem
            l.setBounds(240,70,300,40);//posição da mensagem
        fram.add(l);//add ela
            JButton adicionar = new JButton("Criar novo usuário");//botao add
                adicionar.setBounds(220, 150, 150, 35);//tamanho e posição dele
                    fram.add(adicionar);// add o botao
                       JButton lista = new JButton("Lista de usuários");//botao lista
                            lista.setBounds(220,200,150,35);
                                fram.add(lista);
                            JButton remov = new JButton("Remove usuário");//botao remove
                        remov.setBounds(220,250,150,35);
                    fram.add(remov);
                JButton sair = new JButton("Sair do Login");
                    sair.setBounds(220,300,150,35);
                        fram.add(sair);
                adicionar.addActionListener(new ActionListener() {//configurando o botao de adicionar
                    @Override
                        public void actionPerformed(ActionEvent e){
                    fram.dispose();//apagou a tela anterior
                        JFrame fra = new JFrame();//nova janela de add o usuario
                             fra.setTitle("Adicionando usuário");
                                fra.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                    fra.setSize(600, 500);
                                fra.getContentPane().setBackground(Color.WHITE);
                            fra.setLocationRelativeTo(null);
                        fra.setLayout(null);
                    JLabel usuario = new JLabel("Escrava o nome do usuário: ");
                        usuario.setBounds(30,120,180,25);
                            fra.add(usuario);
                                fra.setVisible(true);
                    JTextField nomeUsuario = new JTextField();
                        nomeUsuario.setBounds(30,150,100,25);
                            fra.add(nomeUsuario);
                    JLabel chave = new JLabel("Senha do Usuário: ");
                        chave.setBounds(30,200,180,25);
                            fra.add(chave);
                    JTextField senhaUsuario = new JTextField();
                        senhaUsuario.setBounds(30,235,100,25);
                            fra.add(senhaUsuario);
                    JButton bt = new JButton("Adicionar usuário");
                        bt.setBounds(220,350,150,35);
                            fra.add(bt);
                        bt.addActionListener(new ActionListener() {//Se lembre que os botoes tem que recebe os dados para poder avançar senão dar erro
                            @Override
                        public void actionPerformed(ActionEvent e){
                        String campoNome = nomeUsuario.getText();
                        String campoSenha = senhaUsuario.getText();
                        map.put(campoNome,campoSenha);
                        try{
                            MessageDigest diges = MessageDigest.getInstance("SHA-384");
                            byte[] hashBytes2 = diges.digest(campoNome.getBytes());
                            StringBuilder M = new StringBuilder();
                            for(byte c : hashBytes2)
                                M.append(String.format("%02x",c));
                            MessageDigest dige = MessageDigest.getInstance("SHA-384");
                            byte[] hashBytes3 = dige.digest(campoSenha.getBytes());
                            StringBuilder bl = new StringBuilder();
                            for(byte d : hashBytes3)
                                bl.append(String.format("%02x", d));
                        }catch(Exception b){
                            b.printStackTrace();
                        }//Ser lembre do if e else Kevin
                                JOptionPane.showMessageDialog(botao, "Usuário adicionado com sucesso!");
                                fra.dispose();
                                fram.setVisible(true);
                                }
                            });
                        } 
                    });
                        lista.addActionListener(new ActionListener() {//Inicio do botao lista
                            @Override
                               public void actionPerformed(ActionEvent e){
                                fram.dispose();
                                    JFrame list = new JFrame();
                                        list.setTitle("Lista de Usuários");
                                            list.setSize(600, 500);
                                                list.getContentPane().setBackground(Color.WHITE);
                                                    list.setLocationRelativeTo(null);
                                                        list.setLayout(null);
                                JLabel x = new JLabel("Lista de usuários cadastrados: ");
                                    x.setBounds(30,100,200,35);
                                    list.add(x);
                                    //add os usuarios na lista(e aprendendo pois me perdi aqui)
                                    int y = 130;
                                    for (String nome : map.keySet()) {// : = em
                                        JLabel userLabel = new JLabel("- " + nome);
                                            userLabel.setBounds(30,y, 200, 25);
                                            y += 20;//o y esta controlando a lista para ela fica em ordem 
                                                list.add(userLabel);
                                                }
                                    JButton s = new JButton("Sair");
                                    s.setBounds(235,300,100,35);
                                    list.add(s);
                                    s.addActionListener(new ActionListener() {
                                        @Override
                                        public void actionPerformed(ActionEvent e){
                                            list.dispose();
                                            fram.setVisible(true);
                                        }
                                    });//Botao sair da tela lista
                                list.setVisible(true);
                    }//botao lista
                });
                    remov.addActionListener(new ActionListener() {
                        @Override
                            public void actionPerformed(ActionEvent e){
                                fram.dispose();
                                    JFrame re = new JFrame();
                                        re.setTitle("Tela Delete");
                                            re.setSize(600, 500);
                                                re.getContentPane().setBackground(Color.WHITE);
                                                    re.setLocationRelativeTo(null);
                                                        re.setLayout(null);
                                JLabel la = new JLabel("Informe o nome do usuário: ");
                                    la.setBounds(30,90,200,35);
                                        re.add(la);
                                JTextField t = new JTextField();
                                    t.setBounds(30, 120, 150, 25);
                                        re.add(t);
                                JButton sa = new JButton("sair");
                                    sa.setBounds(235,300,100,35);
                                        re.add(sa);
                                sa.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e){
                                        String nomeRemove = t.getText();//o remove não pega os componentes JFrame 
                                            if(map.containsKey(nomeRemove)){//verificar ser a chave esta certa
                                                map.remove(nomeRemove);//remove
                                                    JOptionPane.showMessageDialog(re, "Usuário removido com sucesso!");
                                                        re.setVisible(true);
                                            }else{
                                                re.dispose();
                                            JFrame rv = new JFrame();
                                        rv.getContentPane().setBackground(Color.WHITE);
                                    rv.setSize(300,300);
                                rv.setLocationRelativeTo(null);
                            rv.setLayout(null);
                            JLabel j = new JLabel("deseja continuar?");
                                j.setBounds(10,10,250,35);
                                    rv.add(j);
                            JButton sim = new JButton("Sim");
                                sim.setBounds(30,150,60,25);
                                    rv.add(sim);
                            JButton nao = new JButton("Não");
                                nao.setBounds(150,150,60,25);
                                    rv.add(nao);
                            sim.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e){
                                    rv.dispose();
                                    re.setVisible(true); 
                                }
                            });
                            nao.addActionListener(new ActionListener() {
                                @Override
                                public  void actionPerformed(ActionEvent e){
                                    rv.dispose();
                                    fram.setVisible(true);
                                }
                            });
                            rv.setVisible(true);
                            }                
                        }
                    });
                        re.setVisible(true);
                    }
                });//botao remove  
                sair.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e){
                        texto.setText("");
                        text.setText("");//grava isso na mente Kevin do Futuro.
                        log.setVisible(true);
                        fram.dispose();
                    }
                });          
            fram.setVisible(true);
        }else{   
            //confirmando login do Usuário
        try{
        String campoNome = loginUsuario;
        String campoSenha = senhaUsuario;
            if(map.containsKey(campoNome) && map.get(campoNome).equals(campoSenha)){
                log.dispose();
                try {
                    KeyGenerator keyGen = KeyGenerator.getInstance("AES");
                    keyGen.init(128);
                    chaveGlobal = keyGen.generateKey();
                        } catch (Exception ex) {
                        ex.printStackTrace();
                        }
                    JFrame f = new JFrame();
                        f.setTitle("Tela Usuário");
                            f.setSize(600, 500);
                                f.getContentPane().setBackground(Color.WHITE);
                                    f.setLocationRelativeTo(null);
                                        f.setLayout(null);
                JLabel w = new JLabel("Bem vindo!  "  +  campoNome);
                    w.setBounds(210,100,300,30);
                        w.setFont(new Font("Arial", Font.BOLD,25));
                            f.add(w);
                JButton en = new JButton("Enviar mensagem");
                    en.setBounds(220,200,150,35);
                        f.add(en);
                JButton in = new JButton("Ler mensagem");
                    in.setBounds(220,250,150,35);
                        f.add(in);
                JButton an = new JButton("Sair");
                    an.setBounds(220,300,150,35);  
                        f.add(an);
                en.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e){
                        f.dispose();
                        JFrame men = new JFrame();
                             men.setTitle("Tela de Envio");
                                    men.setSize(600, 500);//tamanho da janela
                                        men.getContentPane().setBackground(Color.WHITE);//cor da janela
                                            men.setLocationRelativeTo(null);//centraliza a janela
                                                men.setLayout(null);//organização em null
                        JLabel d = new JLabel("Tela de Envio");
                            d.setFont(new Font("Arial", Font.ITALIC, 25));
                                d.setBounds(210,50,300,30);
                                    men.add(d);
                        JLabel te = new JLabel("Escreva sua mensagem:");
                            te.setBounds(30,90,200,35);
                                men.add(te);
                        JTextArea tex = new JTextArea();
                            tex.setBounds(30,120,600,100);
                                men.add(tex);
                        JButton v = new JButton("Enviar");
                            v.setBounds(160,300,90,25);
                                men.add(v);
                        JLabel q = new JLabel("Distinatário: ");
                            q.setBounds(30,230,100,25);
                                men.add(q);
                        JTextField k = new JTextField();
                            k.setBounds(130,230,150,25);
                                men.add(k);
                        JButton s = new JButton("Sair");
                            s.setBounds(280,300,90,25);
                                men.add(s);
                        v.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e){
                                try{
                                        f.dispose();
                                        KeyGenerator chave =  KeyGenerator.getInstance("AES");
                                        chave.init(128);
                                        chaveGlobal = chave.generateKey();
                                        String mensagemEnviada = tex.getText();
                                        Cipher cipher = Cipher.getInstance("AES");
                                        cipher.init(Cipher.ENCRYPT_MODE, chaveGlobal);
                                        byte[] mensagemcripto = cipher.doFinal(mensagemEnviada.getBytes());
                                        String base64 = Base64.getEncoder().encodeToString(mensagemcripto);
                                        String remetente = loginUsuario;
                                        String destinatario = k.getText();
                                        mensa.add(new Mensagem(remetente, destinatario, base64, chaveGlobal));
                                        if(map.containsKey(loginUsuario)){
                                            JOptionPane.showMessageDialog(en,"Mensagem Enviada");

                                         }else{
                                            JOptionPane.showMessageDialog(en,"Usuário não encontrado");
                                            }
                                         }catch(Exception ex){
                                            ex.printStackTrace();
                                         }
                                        men.dispose();
                                            f.setVisible(true);     
                                }
                            });
                        s.addActionListener(new ActionListener() {
                            @Override
                        public void actionPerformed(ActionEvent e){
                                men.dispose();
                                f.setVisible(true);
                            }
                        });//botao de sair da tela enviar mens.              
                    men.setVisible(true);
                    }
                });
                in.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e){
                        f.dispose();
                        JFrame ler = new JFrame();
                            ler.setTitle("Tela Visualização");
                                    ler.setSize(600, 500);//tamanho da janela
                                        ler.getContentPane().setBackground(Color.WHITE);//cor da janela
                                            ler.setLocationRelativeTo(null);//centraliza a janela
                                                ler.setLayout(null);//organização em null
                        JLabel le = new JLabel("Caixa de Mensagem");
                            le.setBounds(30,90,260,35);
                                ler.add(le);
                        JTextArea ss = new JTextArea();
                            ss.setBounds(30,120,650,35);
                                ler.add(ss);
                        JButton se =  new JButton("Sair");
                            se.setBounds(250,300,90,25);
                                ler.add(se);
                        se.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e){
                                ler.dispose();
                                f.setVisible(true);
                            }
                        });
                        //decifrando a mensagem
                        try{
                            
                        for(Mensagem msg : mensa){
                            if(msg.destinatario.equals(loginUsuario)){
                                byte[] mensagembyte = Base64.getDecoder().decode(msg.conteudoCriptografado);
                                KeyGenerator chave = KeyGenerator.getInstance("AES");
                                chave.init(128);
                                Cipher cipher = Cipher.getInstance("AES");
                                cipher.init(Cipher.DECRYPT_MODE,msg.chaveUsada);
                                byte[] mensagemDecripto = cipher.doFinal(mensagembyte);
                                String texto = new String(mensagemDecripto, StandardCharsets.UTF_8);
                                ss.append("De: " + msg.remetente + "\n");
                                ss.append("Mensagem: " + texto + "\n\n");
                                
                            }
                           
                        }
                        }catch(Exception ex){
                            ex.printStackTrace();
                            JOptionPane.showMessageDialog(null, "Erro ao descriptografar mensagens.");

                        }
                    ler.setVisible(true);
                    }
                });

                an.addActionListener(new ActionListener() {//botao sair configurado
                    @Override
                    public void actionPerformed(ActionEvent e){
                        texto.setText("");
                        text.setText("");
                        f.dispose();
                        log.setVisible(true);
                    }
                });//botão sair do usuário
                f.setVisible(true);
            }else{
            JOptionPane.showMessageDialog(botao, "Login ou Senha incorretos");
                }
            }catch(NumberFormatException ex){
                JOptionPane.showMessageDialog(botao, "Erro");

                } 
            }
        }
    });
    log.setVisible(true);//sempre fica para o final
    }
    public static void main(String[] args) {
        new login();
    }
}