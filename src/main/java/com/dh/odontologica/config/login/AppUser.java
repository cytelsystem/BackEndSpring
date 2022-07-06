package com.dh.odontologica.config.login;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;

@Entity
public class AppUser implements UserDetails {
    @Id
    @SequenceGenerator(name = "user_sequence", sequenceName = "user_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_sequence")
    @Column(name = "id", nullable = false)
    private Long id;

    private String nombre;
    private String username;
    private String email;
    private String Password;

    @Enumerated(EnumType.STRING)
    private AppUsuarioRoles appUsuarioRole;


    //****************************Constructores**********************************//


    public AppUser() {
    }

    public AppUser(String nombre, String username, String email, String password, AppUsuarioRoles appUsuarioRole) {
        this.nombre = nombre;
        this.username = username;
        this.email = email;
        Password = password;
        this.appUsuarioRole = appUsuarioRole;
    }

//****************************Getter y Setter************************************//

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public AppUsuarioRoles getAppUsuarioRole() {
        return appUsuarioRole;
    }

    public void setAppUsuarioRole(AppUsuarioRoles appUsuarioRole) {
        this.appUsuarioRole = appUsuarioRole;
    }


    //*******************************Metodos******************************//

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority grantedAuthority = new SimpleGrantedAuthority(appUsuarioRole.name());
        return Collections.singletonList(grantedAuthority);
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    //********************************************************************//

}
