/*
 * Copyright (c) 2025 Eclipse Dirigible contributors
 *
 * All rights reserved. This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v2.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * SPDX-FileCopyrightText: Eclipse Dirigible contributors SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.dirigible.components.odata.domain;

import java.util.Arrays;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import org.eclipse.dirigible.components.base.artefact.Artefact;

import com.google.gson.annotations.Expose;

/**
 * The OData Schema Entity.
 */
@Entity
@Table(name = "DIRIGIBLE_ODATA_SCHEMA")
public class ODataSchema extends Artefact {

    /** The Constant ARTEFACT_TYPE. */
    public static final String ARTEFACT_TYPE = "odataschema";

    /** The id. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ODATAX_ID", nullable = false)
    private Long id;

    /** The content. */
    @Column(name = "ODATAX_CONTENT", columnDefinition = "BLOB", nullable = true)
    @Expose
    private byte[] content;

    /**
     * Instantiates a new o data schema.
     *
     * @param location the location
     * @param name the name
     * @param description the description
     * @param dependencies the dependencies
     * @param content the content
     */
    public ODataSchema(String location, String name, String description, Set<String> dependencies, byte[] content) {
        super(location, name, ARTEFACT_TYPE, description, dependencies);
        this.content = content;
    }

    /**
     * Instantiates a new o data schema.
     */
    public ODataSchema() {
        super();
    }

    /**
     * Gets the id.
     *
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the id.
     *
     * @param id the new id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets the content.
     *
     * @return the content
     */
    public byte[] getContent() {
        return content;
    }

    /**
     * Sets the content.
     *
     * @param content the new content
     */
    public void setContent(byte[] content) {
        this.content = content;
    }

    /**
     * To string.
     *
     * @return the string
     */
    @Override
    public String toString() {
        return "ODataSchema [id=" + id + ", content=" + Arrays.toString(content) + ", location=" + location + ", name=" + name + ", type="
                + type + ", description=" + description + ", key=" + key + ", dependencies=" + dependencies + ", createdBy=" + createdBy
                + ", createdAt=" + createdAt + ", updatedBy=" + updatedBy + ", updatedAt=" + updatedAt + "]";
    }

}
