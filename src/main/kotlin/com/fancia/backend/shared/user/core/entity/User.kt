package com.fancia.backend.shared.user.core.entity

import com.fancia.backend.shared.common.core.entity.AbstractEntity
import com.fancia.backend.shared.common.social.core.entity.Link
import com.fancia.backend.shared.user.core.enums.AccountStatus
import com.fancia.backend.shared.user.core.enums.Gender
import com.fancia.backend.shared.user.core.enums.ProfileVisibility
import com.fancia.backend.shared.user.core.enums.Role
import jakarta.persistence.*
import org.springframework.security.core.GrantedAuthority
import java.time.LocalDate
import java.time.LocalDateTime
import java.util.UUID
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.oauth2.core.user.OAuth2User

@Entity
@Table(name = "`users`")
class User() : AbstractEntity(), UserDetails {
    var email: String? = ""
    private var password: String? = ""
    var firstName: String? = ""
    var lastName: String? = ""
    var profileImageUrl: String? = ""
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 16)
    var status: AccountStatus = AccountStatus.REGISTERED

    @Column(name = "premium_active", nullable = false)
    var premiumActive: Boolean = false

    @Column(name = "premium_expires_at")
    var premiumExpiresAt: LocalDateTime? = null

    @Enumerated(EnumType.STRING)
    var role: Role? = Role.USER

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    val connectedAccounts: MutableList<UserConnectedAccount?> = ArrayList()

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "user_privileges",
        joinColumns = [JoinColumn(name = "user_id", referencedColumnName = "id")],
        inverseJoinColumns = [JoinColumn(name = "privilege_id", referencedColumnName = "id")]
    )
    val privileges: MutableSet<Privilege> = mutableSetOf()

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "user_links", joinColumns = [JoinColumn(name = "user_id")])
    var links: MutableSet<Link> = mutableSetOf()

    @Column(length = 4000)
    var bio: String? = null

    @Column(length = 500)
    var locationLabel: String? = null

    @Column(name = "birth_date")
    var birthDate: LocalDate? = null

    @Enumerated(EnumType.STRING)
    @Column(length = 1)
    var gender: Gender? = null

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 16)
    var visibility: ProfileVisibility = ProfileVisibility.PUBLIC

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "user_tags", joinColumns = [JoinColumn(name = "user_id")])
    @Column(name = "tag_id")
    var tags: MutableSet<UUID> = mutableSetOf()

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "user_blacklist_ids", joinColumns = [JoinColumn(name = "user_id")])
    @Column(name = "blacklisted_id")
    var blacklistedIds: MutableSet<UUID> = mutableSetOf()

    @OneToOne(mappedBy = "user", cascade = [CascadeType.ALL], fetch = FetchType.EAGER, orphanRemoval = true)
    var settings: UserSettings? = null

    constructor(oAuth2User: OAuth2User) : this() {
        this.email = oAuth2User.getAttribute("email") ?: throw kotlin.IllegalArgumentException("Email cannot be null")
        val name: String? = oAuth2User.getAttribute("name")
        if (name != null) {
            val names = name.split(" ").filter { it.isNotEmpty() }
            if (names.size > 1) {
                this.firstName = names[0]
                this.lastName = names[1]
            } else {
                this.firstName = names.first()
            }
        }
        this.status = AccountStatus.ACTIVE
        this.role = Role.USER
    }

    override fun getAuthorities(): Collection<GrantedAuthority> {
        val authorities = mutableListOf<GrantedAuthority>()
        privileges.forEach { it.name?.let { authority -> authorities.add(SimpleGrantedAuthority(authority)) } }
        authorities.add(SimpleGrantedAuthority("ROLE_$role"))
        return authorities
    }

    override fun getUsername(): String {
        return email ?: ""
    }

    override fun isAccountNonExpired(): Boolean {
        return true
    }

    override fun isAccountNonLocked(): Boolean {
        return true
    }

    override fun isCredentialsNonExpired(): Boolean {
        return true
    }

    override fun isEnabled(): Boolean {
        return status != AccountStatus.INACTIVE
    }

    override fun getPassword(): String? {
        return password
    }

    fun setPassword(newPassword: String) {
        password = newPassword
    }
}