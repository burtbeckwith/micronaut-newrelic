/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * Copyright 2020 Agorapulse.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.agorapulse.micronaut.newrelic

import com.agorapulse.micronaut.grails.MicronautGrailsConfiguration
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.ApplicationContext
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

@SuppressWarnings('Instanceof')
@ContextConfiguration(classes = [NewRelicInsightsGrailsConfiguration, MicronautGrailsConfiguration])
class SpringIntegrationSpec extends Specification {

    @Autowired ApplicationContext applicationContext

    void 'configuration service is injected'() {
        when:
            Object bean = applicationContext.getBean('newRelicInsightsService')
        then:
            bean instanceof FallbackNewRelicInsightsService
    }

}

