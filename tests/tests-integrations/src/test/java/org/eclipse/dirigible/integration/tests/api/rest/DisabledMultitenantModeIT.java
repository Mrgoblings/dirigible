/*
 * Copyright (c) 2025 Eclipse Dirigible contributors
 *
 * All rights reserved. This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v2.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * SPDX-FileCopyrightText: Eclipse Dirigible contributors SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.dirigible.integration.tests.api.rest;

import org.eclipse.dirigible.commons.config.DirigibleConfig;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class DisabledMultitenantModeIT extends TenantDeterminationIT {

    @BeforeAll
    public static void setUp() {
        DirigibleConfig.MULTI_TENANT_MODE_ENABLED.setBooleanValue(false);
    }

    @Test
    void testEveryHostIsResolvedToDefaultTenant() {
        testHealthIsAccessible("localhost", null);
        testHealthIsAccessible("default.localhost", null);
        testHealthIsAccessible("host-which-does-not-match-the-default-tenant-regex", null);
        testHealthIsAccessible("unregistered-tenant.localhost", null);
        testHealthIsAccessible("212.39.89.114", "unregistered-tenant.localhost");
    }

}
